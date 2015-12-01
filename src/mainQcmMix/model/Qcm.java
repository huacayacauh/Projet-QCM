package mainQcmMix.model;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;

public class Qcm {
	private int id;
	private int pl,pc;
	private int al,ac,bl,bc,cl,cc,dl,dc;

	// servit à préserver les caractéres gras dans une cellule
	private HSSFRichTextString choix1 = new HSSFRichTextString("");
	private HSSFRichTextString choix2 = new HSSFRichTextString("");
	private HSSFRichTextString choix3 = new HSSFRichTextString("");
	private HSSFRichTextString choix4 = new HSSFRichTextString("");
	private boolean flaga = true,flagb = true,flagc = true,flagd=true;

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
	public int getBl() {
		return bl;
	}
	public void setBl(int bl) {
		this.bl = bl;
	}
	public int getBc() {
		return bc;
	}
	public void setBc(int bc) {
		this.bc = bc;
	}
	public int getCl() {
		return cl;
	}
	public void setCl(int cl) {
		this.cl = cl;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getDl() {
		return dl;
	}
	public void setDl(int dl) {
		this.dl = dl;
	}
	public int getDc() {
		return dc;
	}
	public void setDc(int dc) {
		this.dc = dc;
	}
	public HSSFRichTextString getChoix1() {
		return choix1;
	}
	public void setChoix1(HSSFRichTextString choix1) {
		this.choix1 = choix1;
	}
	public HSSFRichTextString getChoix2() {
		return choix2;
	}
	public void setChoix2(HSSFRichTextString choix2) {
		this.choix2 = choix2;
	}
	public HSSFRichTextString getChoix3() {
		return choix3;
	}
	public void setChoix3(HSSFRichTextString choix3) {
		this.choix3 = choix3;
	}
	public HSSFRichTextString getChoix4() {
		return choix4;
	}
	public void setChoix4(HSSFRichTextString choix4) {
		this.choix4 = choix4;
	}
	public boolean isFlaga() {
		return flaga;
	}
	public void setFlaga(boolean flaga) {
		this.flaga = flaga;
	}
	public boolean isFlagb() {
		return flagb;
	}
	public void setFlagb(boolean flagb) {
		this.flagb = flagb;
	}
	public boolean isFlagc() {
		return flagc;
	}
	public void setFlagc(boolean flagc) {
		this.flagc = flagc;
	}
	public boolean isFlagd() {
		return flagd;
	}
	public void setFlagd(boolean flagd) {
		this.flagd = flagd;
	}



}
