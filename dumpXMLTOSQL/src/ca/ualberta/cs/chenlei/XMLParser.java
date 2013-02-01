package ca.ualberta.cs.chenlei;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;



public class XMLParser extends DefaultHandler{
	//ArrayList<Employee> myEmpls = null;
	Connection con = null;
	Statement st = null;
	private String tempVal;
	private Employee tempEmp;
	private boolean end = false;
	

	private void parseDocument() {
		//myEmpls = new ArrayList<Employee>();
		//get a factory
		connectDB connectdb = new connectDB();
		con = connectdb.conDB();
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {

			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();

			//parse the file and also register this class for call backs
			sp.parse("employees.xml", this);

		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		tempVal = "";
		if(qName.equalsIgnoreCase("Employee")) {
			//create a new instance of employee
			tempEmp = new Employee();
			tempEmp.setType(attributes.getValue("type"));
		}
	}


	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		//if(qName.equalsIgnoreCase("Employee")) {
			//add it to the list
			//myEmpls.add(tempEmp);

		//}else 
		if (qName.equalsIgnoreCase("Name")) {
			tempEmp.setName(tempVal);
		}else if (qName.equalsIgnoreCase("Id")) {
			tempEmp.setId(Integer.parseInt(tempVal));
		}else if (qName.equalsIgnoreCase("Age")) {
			tempEmp.setAge(Integer.parseInt(tempVal));
			end = true;
		}
        
		if(end){
		try{
			Statement st = con.createStatement();
			st.executeUpdate("insert into employee values ('"+ tempEmp.getType() + "','"+ tempEmp.getName()+
					"','"+tempEmp.getId()+ "','" + tempEmp.getAge() +"')");
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		end = false;
		}


	}

	public static void main(String[] args){
		XMLParser xmlp = new XMLParser();
		xmlp.parseDocument();




		//ArrayList<Employee> myEmpls = xmlp.parseDocument();

/*		for(int i=0; i < myEmpls.size(); i++) {
			try{
				Statement st = con.createStatement();
				st.executeUpdate("insert into employee values ('"+ myEmpls.get(i).getType() + "','"+ myEmpls.get(i).getName()+
						"','"+myEmpls.get(i).getId()+ "','" + myEmpls.get(i).getAge() +"')");
				st.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(myEmpls.get(i).toString());
		}
*/

	}

}
