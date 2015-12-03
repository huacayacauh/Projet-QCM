package mainQcmMix.model;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;

public class Qcm {
	private int id;
	private int pl, pc;
	private int al, ac;
	private List<HSSFRichTextString> choixs ;
	private List<String> testerreurs ;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPl() {
		return pl;
	}

	public void setPl(int pl) {
		this.pl = pl;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getAl() {
		return al;
	}

	public void setAl(int al) {
		this.al = al;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public List<HSSFRichTextString> getChoixs() {
		return choixs;
	}

	public void setChoixs(List<HSSFRichTextString> choixs) {
		this.choixs = choixs;
	}

	public List<String> getTesterreurs() {
		return testerreurs;
	}

	public void setTesterreurs(List<String> testerreurs) {
		this.testerreurs = testerreurs;
	}


}
