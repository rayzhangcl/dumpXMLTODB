package ca.ualberta.cs.chenlei;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
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
	private Users tempO;
	PreparedStatement pst = null;
	private StringBuilder tempString = new StringBuilder();
	private static StringBuilder left = new StringBuilder();
	private int count = 0;
	private void parseDocument() {
		//myEmpls = new ArrayList<Employee>();
		//connect database
		connectDB connectdb = new connectDB();
		con = connectdb.conDB();

		try{pst = con.prepareStatement("insert into users values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {

			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();

			//parse the file and also register this class for call backs
			sp.parse("stack-overflow/users.xml", this);

		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}

		try{
			pst.executeBatch();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		//tempVal = "";
		tempO = new Users();
		if(qName.equalsIgnoreCase("row")) {
			//create a new instance of employee
			tempO.setId(attributes.getValue("Id"));
			tempO.setReputation(attributes.getValue("Reputation"));	
			tempO.setCreationDate(attributes.getValue("CreationDate"));
			tempO.setDisplayName(attributes.getValue("DisplayName"));
			tempO.setEmailHash(attributes.getValue("EmailHash"));
			tempO.setLastAccessDate(attributes.getValue("LastAccessDate"));
			tempO.setWebsiteUrl(attributes.getValue("WebsiteUrl"));
			tempO.setLocation(attributes.getValue("Location"));
			tempO.setAge(attributes.getValue("Age"));
			tempO.setAboutMe(attributes.getValue("AboutMe"));
			tempO.setViews(attributes.getValue("Views"));
			tempO.setUpVotes(attributes.getValue("UpVotes"));
			tempO.setDownVotes(attributes.getValue("DownVotes"));
			//System.out.println(tempEmp.toString()+"\n");
			count++;
			try{ 
				pst.setString(1, tempO.getId());
				pst.setString(2, tempO.getReputation());
				pst.setString(3, tempO.getCreationDate());
				pst.setString(4, tempO.getDisplayName());
				pst.setString(5, tempO.getEmailHash());
				pst.setString(6, tempO.getLastAccessDate());			
				pst.setString(7, tempO.getWebsiteUrl());
				pst.setString(8, tempO.getLocation());
				pst.setString(9, tempO.getAge());			
				pst.setString(10, tempO.getAboutMe());
				pst.setString(11, tempO.getViews());
				pst.setString(12, tempO.getUpVotes());
				pst.setString(13, tempO.getDownVotes());
				pst.addBatch();   }
			catch (SQLException e) {
				e.printStackTrace();
			}

			/*tempString.append("('"+tempO.getId()+"','"+tempO.getReputation()+"','"
			+tempO.getCreationDate()+"','"
			+tempO.getDisplayName()+"','"
			+tempO.getEmailHash()
			+"','"+tempO.getLastAccessDate()+"','"+tempO.getWebsiteUrl()
			+"','"+tempO.getLocation()+"','"+tempO.getAge()
			+"','"+tempO.getAboutMe()+"','"+tempO.getViews()
			+"','"+tempO.getUpVotes()+"','"+tempO.getDownVotes()
			+"'),");*/
		}

		//1000 times
		if((count != 0)&&((count % 1000) == 0)){
			try{
				pst.executeBatch();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

			//InputStream is = new ByteArrayInputStream(tempString.toString().getBytes());
			/*tempString.deleteCharAt(tempString.length()-1);
			System.out.println("have saved " + count +" rows now ...");
			try{
				Statement st = con.createStatement();
                	st.executeUpdate("insert into users values "+ tempString);
				st.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}*/
			System.out.println("done!");
			//tempString.delete(0, tempString.capacity());
		}
		//left = tempString;

		/*else if (qName.equalsIgnoreCase("Name")) {
			pName = true;
			tempEmp.setType(attributes.getValue("Name"));
			System.out.println(tempEmp.toString()+"\n");
		}else if (qName.equalsIgnoreCase("Id")) {
			pId = true;
			tempEmp.setType(attributes.getValue("Id"));
			System.out.println(tempEmp.toString()+"\n");
		}else if (qName.equalsIgnoreCase("Age")) {
			pAge = true;
			tempEmp.setType(attributes.getValue("Age"));
			System.out.println(tempEmp.toString()+"\n");
		}*/
	}


	/*	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
        if (pType) {
           tempEmp.setType(tempVal);
			System.out.println(tempEmp.toString()+"\n");
            pType = false;
        } else if (pName){
        	tempEmp.setName(tempVal);
			System.out.println(tempEmp.toString()+"\n");
        	pName = false;
        }else if (pId){
        	tempEmp.setId(Integer.parseInt(tempVal));
			System.out.println(tempEmp.toString()+"\n");
        	pId = false;
        } else if (pAge){
        	tempEmp.setAge(Integer.parseInt(tempVal));
			System.out.println(tempEmp.toString()+"\n");
        	pAge = false;
        }
	}*/

	/*	public void endElement(String uri, String localName, String qName) throws SAXException {

		System.out.println(tempEmp.toString()+"\nabcd");

		//if(qName.equalsIgnoreCase("/")) {
			//an entry is ready and save it
			try{
				Statement st = con.createStatement();
				st.executeUpdate("insert into employee values ('"+ tempEmp.getType() + "','"+ tempEmp.getName()+
						"','"+tempEmp.getId()+ "','" + tempEmp.getAge() +"')");
				st.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}

		}else if (qName.equalsIgnoreCase("Name")) {
			tempEmp.setName(tempVal);
		}else if (qName.equalsIgnoreCase("Id")) {
			tempEmp.setId(Integer.parseInt(tempVal));
		}else if (qName.equalsIgnoreCase("Age")) {
			tempEmp.setAge(Integer.parseInt(tempVal));
		}
	}*/

	public static void main(String[] args){
		XMLParser xmlp = new XMLParser();
		xmlp.parseDocument();

		//save the last part
		connectDB connectdb = new connectDB();
		Connection connect = connectdb.conDB();


		/*left.deleteCharAt(left.length()-1);
		try{
			Statement st = connect.createStatement();
            		st.executeUpdate("insert into users values "+ left);
			st.close();
			System.out.println("Finally!!!");
		}catch (SQLException e) {
			e.printStackTrace();
		}*/
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