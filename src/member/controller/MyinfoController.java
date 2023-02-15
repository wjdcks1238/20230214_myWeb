package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.controller.vo.MemberVo;
import kh.member.model.service.MemberService;

/**
 * Servlet implementation class MyinfoController
 */
@WebServlet("/myinfo")
public class MyinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1
		//2 나의 id에 해당하는 정보를 db에서 읽어오기
		String id = null;
		if(request.getSession().getAttribute("lgnss") != null) {			
			id = ((MemberVo)(request.getSession().getAttribute("lgnss"))).getId();
		}
		
		if(id != null) {
			request.setAttribute("myinfo", new MemberService().myInfo(id));
		}
		
		request.getRequestDispatcher("/WEB-INF/view/member/myinfo.jsp").forward(request, response);
		}

}
