package HomeWork1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(urlPatterns = "/products/*")
public class AllProducts extends HttpServlet {
    private ProductRepo products;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        if (req.getPathInfo() != null) {
            Optional<Product> prod = this.products.findAll()
                    .stream().filter(product -> product.getId() == Integer.parseInt(req.getPathInfo().substring(1))).findFirst();
            if (!prod.get().equals(null)) {
                pw.println("<h1>Привет медвед!</h1>");
                pw.println("<ul>");
                pw.printf("<h2>Product id: %s</h2>", prod.get().getId());
                pw.printf("<h2>Product title: %s</h2>", prod.get().getTitle());
                pw.printf("<h2>Product cost: %d</h2>", prod.get().getCost());
                pw.println("</ul>");
            }
        } else {
            pw.println("<h1>Привет медвед!</h1>");
            pw.println("<ul>");
            this.products.findAll()
                    .stream()
                    .forEach(
                            product -> pw.printf("<li><p> <a href='%s%s%s%d'>    %d   </a> %s </p></li>",
                                                 req.getContextPath(),
                                                 req.getServletPath(),
                                                 "/",
                                                 product.getId(),
                                                 product.getId(),
                                                 product.getTitle())
                    );
            pw.println("</ul>");
        }
    }
    @Override
    public void init() throws ServletException {
        products = new ProductRepo();
        for (int i = 0; i < 10; i++) {
            products.insert(new Product(String.valueOf(i)));
        }
    }
}