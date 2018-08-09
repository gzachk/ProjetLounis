package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Utilisateur;

public class UtilisateurBDD implements UtilisateurBDDImpl{
	protected static Connection conn = null;
	protected static PreparedStatement prepStmt = null;

	public void jdbcConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// System.out.println("- Driver loading succesful -");
			
			// Connect (localhost:3306 -> Windows ports)
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_questionnaire", "root", "");
			System.out.println("- Connection opened -");
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// jdbcConnect()

	public void jdbcDisconnect() {
		try {
			if (prepStmt != null)
				prepStmt.close();
			// System.out.println("Statement closed");
		} catch (SQLException se2) {
		}

		try {
			if (conn != null)
				conn.close();
			System.out.println("- Connection closed -");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}// jdbcDisconnect()
	
// -------------------------------------------------------------------------------

	public ArrayList<Utilisateur> getUser(String valeurRecherche) {
		jdbcConnect();
		ResultSet res = null;
		
		String sql = "SELECT * FROM utilisateur WHERE nom LIKE '%"
				+valeurRecherche+"%' OR prenom LIKE '%"
				+valeurRecherche+"%';";
		
		System.out.println(valeurRecherche);
		
		ArrayList<Utilisateur> listUsers = new ArrayList<Utilisateur>();

		try {
			int idUtilisateur;
			String nom = null;
			String prenom = null;
			String email = null;
			String telephone = null;
			String societe = null;
			boolean isValid = false;
			boolean isAdmin = false;

			prepStmt = conn.prepareStatement(sql);
			res = prepStmt.executeQuery(sql);
			// stmt = conn.createStatement();
			// rs = stmt.executeQuery("SELECT * FROM stagiaire");

			System.out.println("Checking list...");
			while (res.next()) {
				idUtilisateur = res.getInt("ID_UTILISATEUR");
				nom = res.getString("NOM");
				prenom = res.getString("PRENOM");
				email = res.getString("EMAIL");
				telephone = res.getString("TELEPHONE");
				societe = res.getString("SOCIETE");
				isValid = res.getBoolean("IS_VALID");
				isAdmin = res.getBoolean("IS_ADMIN");

				Utilisateur utilisateur = new Utilisateur(idUtilisateur, nom, prenom, email, telephone, societe,
						isValid, isAdmin);
				listUsers.add(utilisateur);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		jdbcDisconnect();
		return listUsers;
	}// getUser();
	// -------------------------------------------------------------------------------
	
	public ArrayList<Utilisateur> getUserById(ArrayList<Integer> idRecherche) {
		jdbcConnect();
		ResultSet res = null;
		String sql = "";
		
		ArrayList<Utilisateur> listUsers = new ArrayList<Utilisateur>();
		
		for (int i = 0; i < idRecherche.size(); i++) {

			
			sql = "SELECT * FROM utilisateur WHERE id_utilisateur='"
					+idRecherche.get(i)+"';";
			
			try {
				int idUtilisateur;
				String nom = null;
				String prenom = null;
				String email = null;
				String telephone = null;
				String societe = null;
				boolean isValid = false;
				boolean isAdmin = false;

				prepStmt = conn.prepareStatement(sql);
				res = prepStmt.executeQuery(sql);

				System.out.println("Checking list...");
				while (res.next()) {
					idUtilisateur = res.getInt("ID_UTILISATEUR");
					nom = res.getString("NOM");
					prenom = res.getString("PRENOM");
					email = res.getString("EMAIL");
					telephone = res.getString("TELEPHONE");
					societe = res.getString("SOCIETE");
					isValid = res.getBoolean("IS_VALID");
					isAdmin = res.getBoolean("IS_ADMIN");

					Utilisateur utilisateur = new Utilisateur(idUtilisateur, nom, prenom, email, telephone, societe,
							isValid, isAdmin);
					listUsers.add(utilisateur);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		

		try {
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		jdbcDisconnect();
		return listUsers;
	}// getUserById();
	// -------------------------------------------------------------------------------
	
	public ArrayList<Utilisateur> getListUsers() {
		jdbcConnect();
		ResultSet res = null;

		ArrayList<Utilisateur> listUsers = new ArrayList<Utilisateur>();

		try {
			int idUtilisateur;
			String nom = null;
			String prenom = null;
			String email = null;
			String telephone = null;
			String societe = null;
			boolean isValid = false;
			boolean isAdmin = false;

			prepStmt = conn.prepareStatement("SELECT * FROM utilisateur");
			res = prepStmt.executeQuery("SELECT * FROM utilisateur");
			// stmt = conn.createStatement();
			// rs = stmt.executeQuery("SELECT * FROM stagiaire");

			System.out.println("Checking list...");
			while (res.next()) {
				idUtilisateur = res.getInt("ID_UTILISATEUR");
				nom = res.getString("NOM");
				prenom = res.getString("PRENOM");
				email = res.getString("EMAIL");
				telephone = res.getString("TELEPHONE");
				societe = res.getString("SOCIETE");
				isValid = res.getBoolean("IS_VALID");
				isAdmin = res.getBoolean("IS_ADMIN");

				Utilisateur utilisateur = new Utilisateur(idUtilisateur, nom, prenom, email, telephone, societe,
						isValid, isAdmin);
				listUsers.add(utilisateur);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		jdbcDisconnect();
		return listUsers;
	}// getListUsers();
	// ----------------------------------------------------------------------------------
	
	public ArrayList<Utilisateur> getListNewUsers() {
		jdbcConnect();
		ResultSet res = null;

		ArrayList<Utilisateur> listUsers = new ArrayList<Utilisateur>();

		try {
			int idUtilisateur = 0;
			String nom;
			String prenom = null;
			String email = null;
			String telephone = null;
			String societe = null;
			String password = null;
			boolean isValid = false;
			boolean isAdmin = false;

			prepStmt = conn.prepareStatement("SELECT * FROM nouvel_utilisateur");
			res = prepStmt.executeQuery("SELECT * FROM nouvel_utilisateur");
			// stmt = conn.createStatement();
			// rs = stmt.executeQuery("SELECT * FROM stagiaire");

			System.out.println("Checking list...");
			while (res.next()) {
				idUtilisateur = res.getInt("ID");
				nom = res.getString("NOM");
				prenom = res.getString("PRENOM");
				email = res.getString("EMAIL");
				telephone = res.getString("TELEPHONE");
				societe = res.getString("SOCIETE");
				password = res.getString("PASSWORD");

				Utilisateur utilisateur = new Utilisateur(idUtilisateur, nom, prenom, email, telephone, societe,
						isValid, isAdmin);
				utilisateur.setPassword(password);
				
				listUsers.add(utilisateur);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		jdbcDisconnect();
		return listUsers;
	}// getListNewUsers()
	// ----------------------------------------------------------------------------------

	public  boolean addUser(Utilisateur nouvelUtilisateur) {
		boolean statut = false;
		String sql = "";
		
			jdbcConnect();
			// Insertion du nouvel utilisateur
			try {
				sql = "INSERT INTO NOUVEL_UTILISATEUR (nom, prenom, email, telephone, societe, password)"
						+ "VALUES (?,?,?,?,?,?)";
				
					statut = true;

					prepStmt = conn.prepareStatement(sql);
					
					prepStmt.setString(1, nouvelUtilisateur.getNom());
					prepStmt.setString(2, nouvelUtilisateur.getPrenom());
					prepStmt.setString(3, nouvelUtilisateur.getEmail());
					prepStmt.setString(4, nouvelUtilisateur.getTelephone());
					prepStmt.setString(5, nouvelUtilisateur.getSociete());
					prepStmt.setString(6, nouvelUtilisateur.getPassword());

					prepStmt.executeUpdate();
					
					System.out.println("	Utilisateur "+nouvelUtilisateur.getNom()+" "+nouvelUtilisateur.getPrenom()+" inscrit.");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
			System.out.println("Deconnexion imminente....");
			jdbcDisconnect();
		
		return statut;
	 }// addUser()
	// ----------------------------------------------------------------------------------

	public void validerUser(ArrayList<Utilisateur> utilisateurValider) {
		String sql = "";
		//String sqlPassword = "";

		jdbcConnect();

		for (int i = 0; i < utilisateurValider.size(); i++) {

			try {
				sql = "INSERT INTO UTILISATEUR (nom, prenom, email, telephone, societe, is_valid, is_admin)" + "VALUES (?,?,?,?,?,?,?)";
				//sqlPassword = "INSERT INTO PASSWORD (password)" + "VALUES (?)";

				prepStmt = conn.prepareStatement(sql);

				prepStmt.setString(1, utilisateurValider.get(i).getNom());
				prepStmt.setString(2, utilisateurValider.get(i).getPrenom());
				prepStmt.setString(3, utilisateurValider.get(i).getEmail());
				prepStmt.setString(4, utilisateurValider.get(i).getTelephone());
				prepStmt.setString(5, utilisateurValider.get(i).getSociete());
				prepStmt.setBoolean(6, utilisateurValider.get(i).isValid());
				prepStmt.setBoolean(7, utilisateurValider.get(i).isAdmin());

				prepStmt.executeUpdate();

				System.out.println("	Utilisateur " + utilisateurValider.get(i).getNom() + " "
						+ utilisateurValider.get(i).getPrenom() + " inscrit.");
				
				removeFromNewUserTable(utilisateurValider.get(i));
				
				linkUserPassword(utilisateurValider.get(i)/*, utilisateurValider.get(i).getPassword()*/);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} // end for

		jdbcDisconnect();

	}// validerUser()
	//---------------------------------------------------------------------------------------
	
	public void removeFromNewUserTable(Utilisateur utilisateur) {

		try {
			String sql = "DELETE FROM nouvel_utilisateur WHERE id = '" + utilisateur.getIdUtilisateur() + "'";
			System.out.println(utilisateur.getIdUtilisateur());

			prepStmt = conn.prepareStatement(sql);
			prepStmt.executeUpdate(sql);
			System.out.println("	utilisateur supprime.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// removeFromNewUserTable()
	//---------------------------------------------------------------------------------------
	
	public void deleteUser(ArrayList<Utilisateur> utilisateurList) {
		if (utilisateurList.size() > 0) {

			jdbcConnect();

			for (int i = 0; i < utilisateurList.size(); i++) {
				
				try {
					String sql = "DELETE FROM password WHERE id_utilisateur = '"+utilisateurList.get(i).getIdUtilisateur()+ "'";

					prepStmt = conn.prepareStatement(sql);
					prepStmt.executeUpdate(sql);
					System.out.println(" - - > mot de passe supprime.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				try {
					String sql = "DELETE FROM utilisateur WHERE id_utilisateur = '"+utilisateurList.get(i).getIdUtilisateur()+ "'";
					System.out.println("id utilisateur a supprime: "+utilisateurList.get(i).getIdUtilisateur());

					prepStmt = conn.prepareStatement(sql);
					prepStmt.executeUpdate(sql);
					System.out.println(" - - > utilisateur supprime.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // end for
			
			jdbcDisconnect();
		}
	}// removeFromNewUserTable()
	//---------------------------------------------------------------------------------------
	
	public void linkUserPassword(Utilisateur nouvelUtilisateur/*, String password*/) {
		String sql = "";
		int idUtilisateur = 0;
		
		String condition = "nom='"+nouvelUtilisateur.getNom();
		condition = condition + "' AND prenom='"+nouvelUtilisateur.getPrenom();
		condition = condition + "' AND email='"+nouvelUtilisateur.getEmail();
		condition = condition + "' AND telephone='"+nouvelUtilisateur.getTelephone();
		condition = condition + "' AND societe='"+nouvelUtilisateur.getSociete()+"'";
		
		System.out.println(condition);
		

		// Recuperation de l'id_utilisateur(de la bdd) pour insertion password -----------------------------------------
		try {
			ResultSet res = null;
			sql = "SELECT id_utilisateur FROM utilisateur WHERE "+condition;
			prepStmt = conn.prepareStatement(sql);
			res = prepStmt.executeQuery(sql);
			
			while (res.next()) {
				idUtilisateur = res.getInt("id_utilisateur");
				System.out.println("Id utilisateur "+idUtilisateur);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Insertion Password -------------------------------------------------------------
		try {
			sql = "INSERT INTO PASSWORD (password, id_utilisateur) VALUES (?,?)";

				prepStmt = conn.prepareStatement(sql);
				
				prepStmt.setString(1, nouvelUtilisateur.getPassword());
				prepStmt.setInt(2, idUtilisateur);

				prepStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// linkUserPassword()
	//---------------------------------------------------------------------------------------
	
	
}// - UtilisateurBDD
