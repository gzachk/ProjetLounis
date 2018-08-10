package model;

public class Choix {
	protected int idParcours;
	protected int idReponse;
// ---------------------------------------------------------------------------------
	public Choix() {
		super();
	}
	public Choix(int idParcours, int idReponse) {
		super();
		this.idParcours = idParcours;
		this.idReponse = idReponse;
	}
// ---------------------------------------------------------------------------------
	public int getIdParcours() {
		return idParcours;
	}
	public void setIdParcours(int idParcours) {
		this.idParcours = idParcours;
	}
	public int getIdReponse() {
		return idReponse;
	}
	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}
// ---------------------------------------------------------------------------------
	
}// - Choix
