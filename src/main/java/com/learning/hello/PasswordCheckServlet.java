package com.learning.hello;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class PasswordCheckServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String inputPassword = request.getParameter("password");
        out.println("<h1>Hello</h1>");
        String filePath = "/home/joseph_b/eclipse-workspace/Web/src/main/java/com/learning/hello/TakenPasswords.txt";
        File file = new File(filePath);
        boolean isPasswordTaken = false;

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(inputPassword)) {
                        isPasswordTaken = true;
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (isPasswordTaken) {
            out.write("Your password is already taken");
        } else {
            out.write("Your password is available");
        }
    }
}

