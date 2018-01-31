package negocio.entities;

public class Nota_Fiscal_Fornecedor {

	private int id;
	private int id_nota_fiscal;
	private double valor_frete;
	private String cfop;
	private double ipi;
	private int icms;
	
	public Nota_Fiscal_Fornecedor(int id, int id_nota_fiscal, double valor_frete, String cfop, double ipi, int icms) {
		
		this.id = id;
		this.id_nota_fiscal = id_nota_fiscal;
		this.valor_frete = valor_frete;
		this.cfop = cfop;
		this.ipi = ipi;
		this.icms = icms;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_nota_fiscal() {
		return id_nota_fiscal;
	}

	public void setId_nota_fiscal(int id_nota_fiscal) {
		this.id_nota_fiscal = id_nota_fiscal;
	}

	public double getValor_frete() {
		return valor_frete;
	}

	public void setValor_frete(double valor_frete) {
		this.valor_frete = valor_frete;
	}

	public String getCfop() {
		return cfop;
	}

	public void setCfop(String cfop) {
		this.cfop = cfop;
	}

	public double getIpi() {
		return ipi;
	}

	public void setIpi(double ipi) {
		this.ipi = ipi;
	}

	public int getIcms() {
		return icms;
	}

	public void setIcms(int icms) {
		this.icms = icms;
	}

	@Override
	public String toString() {
		return "Nota_Fiscal_Fornecedor [id=" + id + ", id_nota_fiscal=" + id_nota_fiscal + ", valor_frete="
				+ valor_frete + ", cfop=" + cfop + ", ipi=" + ipi + ", icms=" + icms + "]";
	}
	
	
}
