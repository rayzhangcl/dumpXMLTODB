package ca.ualberta.cs.chenlei;

import java.io.IOException;
/*import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;*/
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
	private PostHistory tempO;
	PreparedStatement pst = null;
	//private StringBuilder tempString = new StringBuilder();
	//private static StringBuilder left = new StringBuilder();
	private int count = 0;
	private void parseDocument() {
		//myEmpls = new ArrayList<Employee>();
		//connect database
		connectDB connectdb = new connectDB();
		con = connectdb.conDB();
		try{
			con.setAutoCommit(false);
		}catch (SQLException e) {
			e.printStackTrace();
		}


		try{pst = con.prepareStatement("insert into posthistory values (?,?,?,?,?,?,?,?,?,?,?,?)");//12
		}catch (SQLException e) {
			e.printStackTrace();
		}
		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {

			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();

			//parse the file and also register this class for call backs
			sp.parse("stack-overflow/posthistory.xml", this);

		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}

		try{
			pst.executeBatch();
			System.out.println("Finally!");
			con.commit();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		//tempVal = "";
		tempO = new PostHistory();
		if(qName.equalsIgnoreCase("row")) {
			//create a new instance of employee
			tempO.setId(attributes.getValue("Id"));
			tempO.setPostHistoryTypeId(attributes.getValue("PostHistoryTypeId"));	
			tempO.setPostId(attributes.getValue("PostId"));
			tempO.setRevisionGUID(attributes.getValue("RevisionGUID"));
			tempO.setCreationDate(attributes.getValue("CreationDate"));
			tempO.setUserId(attributes.getValue("UserId"));
			tempO.setUserDisplayName(attributes.getValue("UserDisplayName"));
			tempO.setComment(attributes.getValue("Comment"));
			tempO.setText(attributes.getValue("Text"));
			tempO.setCloseReasonId(attributes.getValue("CloseReasonId"));
			//System.out.println(tempEmp.toString()+"\n");
			count++;
			try{ 
				pst.setString(1, tempO.getId());
				pst.setString(2, tempO.getPostHistoryTypeId());
/*				if(Integer.parseInt(tempO.getPostTypeId()) == 1){
					pst.setString(3, "Question");
				}
				if(Integer.parseInt(tempO.getPostTypeId()) == 2){
					pst.setString(3, "Answer");
				}*/
				pst.setString(3, tempO.getPostHistoryType(tempO.getPostHistoryTypeId()));
				pst.setString(4, tempO.getPostId());
				pst.setString(5, tempO.getRevisionGUID());
				pst.setString(6, tempO.getCreationDate());	
				pst.setString(7, tempO.getUserId());
				pst.setString(8, tempO.getUserDisplayName());
				pst.setString(9, tempO.getComment());
				pst.setString(10, tempO.getText());
				pst.setString(11, tempO.getCloseReasonId());
				pst.setString(12, tempO.getCloseReason(tempO.getCloseReasonId()));

				pst.addBatch();   
			}
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
			+"','"+tempO.getUpPostHistory()+"','"+tempO.getDownPostHistory()
			+"'),");*/
		}

		//10000 times
		if((count != 0)&&((count % 10000) == 0)){
			System.out.println("have saved " + count +" rows now ...");

			try{
				pst.executeBatch();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

			try{
				con.commit();
				con.setAutoCommit(false);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("done!");

			//InputStream is = new ByteArrayInputStream(tempString.toString().getBytes());
			/*tempString.deleteCharAt(tempString.length()-1);
			System.out.println("have saved " + count +" rows now ...");
			try{
				Statement st = con.createStatement();
                	st.executeUpdate("insert into PostHistory values "+ tempString);
				st.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}*/
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
        	tempEmp.setId( (tempVal));
			System.out.println(tempEmp.toString()+"\n");
        	pId = false;
        } else if (pAge){
        	tempEmp.setAge( (tempVal));
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
			tempEmp.setId( (tempVal));
		}else if (qName.equalsIgnoreCase("Age")) {
			tempEmp.setAge( (tempVal));
		}
	}*/

	public static void main(String[] args){
		XMLParser xmlp = new XMLParser();
		xmlp.parseDocument();

		//save the last part
		//connectDB connectdb = new connectDB();
		//Connection connect = connectdb.conDB();


		/*left.deleteCharAt(left.length()-1);
		try{
			Statement st = connect.createStatement();
            		st.executeUpdate("insert into PostHistory values "+ left);
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