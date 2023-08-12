package kh.semi.inter.contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.inter.Service.MemberService;
import kh.semi.inter.model.DAO.MemberDAO;
import kh.semi.inter.model.DTO.MemberDTO;

@WebServlet("/memberupdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		request.getRequestDispatcher("/WEB-INF/view/memberUpdate.jsp").forward(request, response);   
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		String name = request.getParameter("name");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		String email = email1 + email2;
		
		String phone = request.getParameter("phone");
		MemberDTO dto = new MemberDTO(loginId, loginPw, name, email, phone);
		
		MemberService service = new MemberService();
		int result = service.update(dto);
		
		//doGet(request, response);
		
		request.getRequestDispatcher("/WEB-INF/view/memberUpdate.jsp").forward(request, response);
	}

}
