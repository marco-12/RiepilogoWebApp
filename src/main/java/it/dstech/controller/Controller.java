package it.dstech.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.model.Persona;

@WebServlet(urlPatterns = "/")
public class Controller extends HttpServlet{
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("emf");
	private static EntityManager em = emf.createEntityManager();

	public void close() {
		em.close();
	}

	
	public void salvaPersona(String Nome, String Cognome, String Eta) {

		Persona persona = new Persona();

		persona.setNome(Nome);
		persona.setCognome(Cognome);
		persona.setEta(Eta);
		
		em.getTransaction().begin();
		em.persist(persona);
		em.getTransaction().commit();

	}
	
	public List<Persona> stampaPersone() {
		TypedQuery<Persona> query = em.createQuery("select p from Persona p", Persona.class);
		return query.getResultList();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Controller controller = new Controller();
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String eta = req.getParameter("eta");

		controller.salvaPersona(nome, cognome, eta);
		req.setAttribute("listaPersone", controller.stampaPersone());
		doGet(req, resp);
	}
	
}
