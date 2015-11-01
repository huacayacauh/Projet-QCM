package mainQcmMix.model;

public class Qcm {

	private String partie;
	private int id;
	private String title;
	private String choix1;
	private String choix2;
	private String choix3;
	private String choix4;

/*	public Qcm(String partie,int id,String title, String choix1,String choix2,String choix3, String choix4){
		this.partie = partie;
		this.id = id;
		this.title = title;
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.choix4 = choix4;
	}*/

	public String getPartie() {
		return partie;
	}
	public void setPartie(String partie) {
		this.partie = partie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChoix1() {
		return choix1;
	}
	public void setChoix1(String choix1) {
		this.choix1 = choix1;
	}
	public String getChoix2() {
		return choix2;
	}
	public void setChoix2(String choix2) {
		this.choix2 = choix2;
	}
	public String getChoix3() {
		return choix3;
	}
	public void setChoix3(String choix3) {
		this.choix3 = choix3;
	}
	public String getChoix4() {
		return choix4;
	}
	public void setChoix4(String choix4) {
		this.choix4 = choix4;
	}


}
