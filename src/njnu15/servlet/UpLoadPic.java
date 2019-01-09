package njnu15.servlet;

import njnu15.bean.Photo;
import njnu15.tool.DAO;

import java.io.File;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



public class UpLoadPic extends HttpServlet {
    public UpLoadPic() {
        super();
    }



    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }



    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String contentType=request.getContentType();
            String servername=request.getServerName();
            String realpath=request.getRealPath(servername);
            // System.out.println(contentType);
            InputStream in=null;
            OutputStream out=null;
            if(contentType.indexOf("multipart/form-data")>=0){
                in=request.getInputStream();
                int formlength=request.getContentLength();
                byte[] formcontent=new byte[formlength];
                int totalread=0;
                int nowread=0;
                while(totalread<formlength){
                    nowread=in.read(formcontent,totalread, formlength);
                    totalread+=nowread;
                }
                String strcontent=new String(formcontent);
                // System.out.println(strcontent);
                int typestart=strcontent.indexOf("Content-Type:")+14;
                int typeend=strcontent.indexOf("\n", typestart)-1;
                String formType=strcontent.substring(typestart, typeend);

                if(formType.equals("image/jpeg")||formType.equals("image/gif")||formType.equals("image/pjepg")||formType.equals("image/png"))
                {
                    int filenamestart=strcontent.indexOf("filename=\"")+10;
                    int filenameend=strcontent.indexOf("\n",filenamestart)-2;
                    String filename=strcontent.substring(filenamestart,filenameend);
                    String fileitem=filename.substring(filename.lastIndexOf("."));//.jpg

                    File tempFile =new File( filename.trim());

                    String newfilename = tempFile.getName();
                    String nameforsql=newfilename;

                    //System.out.println("filename:"+filename);
                    String time = String.valueOf(new Date().getTime());
                    // newfilename="p81217";//filename.substring(0,filename.indexOf("."));

                    System.out.println("item:"+fileitem);
                    newfilename=newfilename;//+fileitem;
                    realpath="D:/images/";
                    newfilename=realpath+newfilename;
                    //System.out.println("newfilename1:"+newfilename);
                    int filestart=strcontent.indexOf("\n",typestart)+1;
                    filestart=strcontent.indexOf("\n",filestart)+1;
                    int intboundary=contentType.indexOf("boundary=")+10;
                    String strboundary=contentType.substring(intboundary);
                    int fileend=strcontent.indexOf(strboundary,filestart)-4;
                    String saveFile=strcontent.substring(filestart,fileend);
                    int contentstart=strcontent.substring(0,filestart).getBytes().length;
                    int contentend=strcontent.substring(0,fileend).getBytes().length;
                    //System.out.println(saveFile);
                    File myfile=new File(realpath);
                    //System.out.println("路径："+realpath);
                    if(!myfile.exists()){

                        myfile.mkdirs();
                    }

                    System.out.println("newfilename2:"+newfilename);
                    out=new FileOutputStream(newfilename);
                    out.write(formcontent, contentstart,contentend-contentstart);

                    Photo pic = new Photo();
                    //pic.setPhotoId(Integer.parseInt(photoId));
                    int x= (int) request.getSession().getAttribute("AID");
                    //System.out.println("aid2："+x);
                    pic.setAlbumId(x);
                    //pic.setAlbumId(123);
                    pic.setPhotoName(nameforsql);
                    pic.setPhotoURL(realpath);
                    Date date=new Date();
                    date.getTime();
                    //Timestamp t = new Timestamp(date.getTime());
                    pic.setUploadTime(date);
                    DAO.addPhoto(pic);

                    //request.getRequestDispatcher("/showAlbum.jsp?albumId="+x).forward(request,response);
                    response.sendRedirect("/showAlbum.jsp?albumId="+x);
                }else{
                    //response.sendRedirect("error.jsp");
                }

        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        doGet(request,response);

    }

    public void insert()
    {

    }

    public void init() throws ServletException {

        // Put your code here

    }



}
