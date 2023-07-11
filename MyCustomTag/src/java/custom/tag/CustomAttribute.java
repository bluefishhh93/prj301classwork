package custom.tag;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author xuant
 */
public class CustomAttribute extends SimpleTagSupport {

    private String name;
    private String time;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
            
            if(name.isEmpty()){
                name = "no name";
            }
            if(time.isEmpty()){
                time = "dd/MM/yyyy";
            }
            
            Date date = new Date();
            String dateFormat = new SimpleDateFormat(time).format(date);
            out.print("Ten: "+name+ "<br/>");
            out.print("Ngay sinh: "+dateFormat+ "<br/>");
            
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in CustomAttribute tag", ex);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}
