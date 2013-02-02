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
	//private String tempVal;
	private Badges tempO;

	private void parseDocument() {
		//myEmpls = new ArrayList<Employee>();
		//connect database
		connectDB connectdb = new connectDB();
		con = connectdb.conDB();

		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {

			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();

			//parse the file and also register this class for call backs
			sp.parse("stack-overflow/*.xml", this);

		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}

		try{
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		//tempVal = "";
		tempO = new Badges();
		if(qName.equalsIgnoreCase("row")) {
			//create a new instance of employee
			tempO.setId(Integer.parseInt(attributes.getValue("Id")));
			tempO.setName(attributes.getValue("Name"));
			tempO.setUserId(Integer.parseInt(attributes.getValue("UserId")));
			tempO.setDate(attributes.getValue("Date"));
			System.out.println(tempO.toString()+"\n");

			try{
				Statement st = con.createStatement();
				st.executeUpdate("insert into badges values ('"+ tempO.getId() + "','"+ tempO.getUserId()+
						"','"+tempO.getName()+ "','" + tempO.getDate() +"')");
				st.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/*else if (qName.equalsIgnoreCase("Name")) {
			pName = true;
			tempO.setType(attributes.getValue("Name"));
			System.out.println(tempO.toString()+"\n");
		}else if (qName.equalsIgnoreCase("Id")) {
			pId = true;
			tempO.setType(attributes.getValue("Id"));
			System.out.println(tempO.toString()+"\n");
		}else if (qName.equalsIgnoreCase("Age")) {
			pAge = true;
			tempO.setType(attributes.getValue("Age"));
			System.out.println(tempO.toString()+"\n");
		}*/
	}


	/*	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
        if (pType) {
           tempO.setType(tempVal);
			System.out.println(tempO.toString()+"\n");
            pType = false;
        } else if (pName){
        	tempO.setName(tempVal);
			System.out.println(tempO.toString()+"\n");
        	pName = false;
        }else if (pId){
        	tempO.setId(Integer.parseInt(tempVal));
			System.out.println(tempO.toString()+"\n");
        	pId = false;
        } else if (pAge){
        	tempO.setAge(Integer.parseInt(tempVal));
			System.out.println(tempO.toString()+"\n");
        	pAge = false;
        }
	}*/

	/*	public void endElement(String uri, String localName, String qName) throws SAXException {

		System.out.println(tempO.toString()+"\nabcd");

		//if(qName.equalsIgnoreCase("/")) {
			//an entry is ready and save it
			try{
				Statement st = con.createStatement();
				st.executeUpdate("insert into employee values ('"+ tempO.getType() + "','"+ tempO.getName()+
						"','"+tempO.getId()+ "','" + tempO.getAge() +"')");
				st.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}

		}else if (qName.equalsIgnoreCase("Name")) {
			tempO.setName(tempVal);
		}else if (qName.equalsIgnoreCase("Id")) {
			tempO.setId(Integer.parseInt(tempVal));
		}else if (qName.equalsIgnoreCase("Age")) {
			tempO.setAge(Integer.parseInt(tempVal));
		}
	}*/

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
