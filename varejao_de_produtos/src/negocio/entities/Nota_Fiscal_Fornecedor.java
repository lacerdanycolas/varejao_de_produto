package negocio.entities;

import dados.MeuId;

public class Nota_Fiscal_Fornecedor {
	@MeuId
	private Integer id;
	private Integer id_nota_fiscal;
	private Double valor_frete;
	private String cfop;
	private Double ipi;
	private Integer icms;
	
	public Nota_Fiscal_Fornecedor(){
		
	}
	
	public Nota_Fiscal_Fornecedor(Integer id_nota_fiscal, Double valor_frete, String cfop, Double ipi, Integer icms) {
		
		this.id_nota_fiscal = id_nota_fiscal;
		this.valor_frete = valor_frete;
		this.cfop = cfop;
		this.ipi = ipi;
		this.icms = icms;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_nota_fiscal() {
		return id_nota_fiscal;
	}

	public void setId_nota_fiscal(Integer id_nota_fiscal) {
		this.id_nota_fiscal = id_nota_fiscal;
	}

	public Double getValor_frete() {
		return valor_frete;
	}

	public void setValor_frete(Double valor_frete) {
		this.valor_frete = valor_frete;
	}

	public String getCfop() {
		return cfop;
	}

	public void setCfop(String cfop) {
		this.cfop = cfop;
	}

	public Double getIpi() {
		return ipi;
	}

	public void setIpi(Double ipi) {
		this.ipi = ipi;
	}

	public Integer getIcms() {
		return icms;
	}

	public void setIcms(Integer icms) {
		this.icms = icms;
	}

	@Override
	public String toString() {
		return "Nota_Fiscal_Fornecedor [id=" + id + ", id_nota_fiscal=" + id_nota_fiscal + ", valor_frete="
				+ valor_frete + ", cfop=" + cfop + ", ipi=" + ipi + ", icms=" + icms + "]";
	}
	
	
}
