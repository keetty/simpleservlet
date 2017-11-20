 package src.database;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;
import java.sql.*; 


public class SessionListener implements HttpSessionListener {




@Override
    public void sessionCreated(HttpSessionEvent se)  {
	try {
StudentDao sd = new StudentDao();
SubjectDao su = new SubjectDao();
DaoMark dm = new DaoMark();
DaoListOfMarks dl = new DaoListOfMarks();

HttpSession session = se.getSession();
if(session!=null) {
session.setAttribute("StudentDao", sd);
session.setAttribute("SubjectDao", su);
session.setAttribute("DaoMark", dm);
session.setAttribute("DaoListOfMarks", dl);
}
} catch(SQLException e) {
e.printStackTrace();
} catch(DaoException e) {
e.printStackTrace();
}
}

@Override
    public void sessionDestroyed(HttpSessionEvent se)  {
		HttpSession session = se.getSession();
		StudentDao sd=(StudentDao)session.getAttribute("StudentDao");
        SubjectDao su=(SubjectDao)session.getAttribute("SubjectDao");
        DaoMark dm=(DaoMark)session.getAttribute("DaoMark");
        DaoListOfMarks dl=(DaoListOfMarks)session.getAttribute("DaoListOfMarks");
	try {
	if(sd!=null) {
	sd.close();
	}
	} catch(DaoException e) {
	e.printStackTrace();
	} 
	try {
	if( su!=null) {
	su.close();
	}
	} catch(DaoException e) {
	e.printStackTrace();
	} 
	try {
	if( dm!=null) {
	dm.close();
	}
	} catch(DaoException e) {
	e.printStackTrace();
	} 
	try {
	if( dl!=null) {
	dl.close();
	}
	} catch(DaoException e) {
	e.printStackTrace();
	} 
	}
	}
	














