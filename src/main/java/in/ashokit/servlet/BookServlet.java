package in.ashokit.servlet;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ashokit.dao.BookDAO;



	@WebServlet("/bookServlet")

	public class BookServlet extends HttpServlet {

		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) {
			try {
				// capture from data
				String id = req.getParameter("bookId");
				String name = req.getParameter("bookName");
				String price = req.getParameter("bookPrice");
				int bookId = Integer.parseInt(id);
				double bookPrice = Double.parseDouble(price);

				// call dao method by giving form data
				BookDAO dao = new BookDAO();
				boolean status = dao.deleteBook(bookId, name, bookPrice);

				// send response to client
				PrintWriter pw = res.getWriter();
				String response = null;

				if (status) {
					response = "Record Inserted";
				} else {
					response = "Insertion Failed";

				}

				pw.append(response);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}


