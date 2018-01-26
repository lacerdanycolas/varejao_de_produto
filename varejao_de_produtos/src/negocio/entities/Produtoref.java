package negocio.entities;
import java.math.BigDecimal;

import dados.MeuId;
public class Produtoref {
	private String codigo_de_barra;
	@MeuId
	private Integer id;
	private String descricao;
	private BigDecimal frequencia_pedido;
	private BigDecimal preco_por_tabela;
	private String cst;
	private BigDecimal icms;
	private String nome;
	private BigDecimal preco_ultima_compra;
	private Integer quantidade_estoque;
	private Integer quantidade_minima;
	private Integer id_fornecedor;
	private Integer id_categoriaref;
	private Integer id_sub_categoriaref;
	private Integer id_unidaderef;
	private Integer id_marcaref;
	private Integer id_ncm;
	
	public Produtoref(){
		
	}
	public Produtoref(String codigo_de_barra, Integer id, String descricao, BigDecimal frequencia_pedido,
			BigDecimal preco_por_tabela, String cst, BigDecimal icms, String nome, BigDecimal preco_ultima_compra,
			Integer quantidade_estoque, Integer quantidade_minima, Integer id_fornecedor, Integer id_categoriaref,
			Integer id_sub_categoriaref, Integer id_unidaderef, Integer id_marcaref, Integer id_ncm) {
		super();
		this.codigo_de_barra = codigo_de_barra;
		this.id = id;
		this.descricao = descricao;
		this.frequencia_pedido = frequencia_pedido;
		this.preco_por_tabela = preco_por_tabela;
		this.cst = cst;
		this.icms = icms;
		this.nome = nome;
		this.preco_ultima_compra = preco_ultima_compra;
		this.quantidade_estoque = quantidade_estoque;
		this.quantidade_minima = quantidade_minima;
		this.id_fornecedor = id_fornecedor;
		this.id_categoriaref = id_categoriaref;
		this.id_sub_categoriaref = id_sub_categoriaref;
		this.id_unidaderef = id_unidaderef;
		this.id_marcaref = id_marcaref;
		this.id_ncm = id_ncm;
	}
	public String getCodigo_de_barra() {
		return codigo_de_barra;
	}
	public void setCodigo_de_barra(String codigo_de_barra) {
		this.codigo_de_barra = codigo_de_barra;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getFrequencia_pedido() {
		return frequencia_pedido;
	}
	public void setFrequencia_pedido(BigDecimal frequencia_pedido) {
		this.frequencia_pedido = frequencia_pedido;
	}
	public BigDecimal getPreco_por_tabela() {
		return preco_por_tabela;
	}
	public void setPreco_por_tabela(BigDecimal preco_por_tabela) {
		this.preco_por_tabela = preco_por_tabela;
	}
	public String getCst() {
		return cst;
	}
	public void setCst(String cst) {
		this.cst = cst;
	}
	public BigDecimal getIcms() {
		return icms;
	}
	public void setIcms(BigDecimal icms) {
		this.icms = icms;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getPreco_ultima_compra() {
		return preco_ultima_compra;
	}
	public void setPreco_ultima_compra(BigDecimal preco_ultima_compra) {
		this.preco_ultima_compra = preco_ultima_compra;
	}
	public Integer getQuantidade_estoque() {
		return quantidade_estoque;
	}
	public void setQuantidade_estoque(Integer quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}
	public Integer getQuantidade_minima() {
		return quantidade_minima;
	}
	public void setQuantidade_minima(Integer quantidade_minima) {
		this.quantidade_minima = quantidade_minima;
	}
	public Integer getId_fornecedor() {
		return id_fornecedor;
	}
	public void setId_fornecedor(Integer id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}
	public Integer getId_categoriaref() {
		return id_categoriaref;
	}
	public void setId_categoriaref(Integer id_categoriaref) {
		this.id_categoriaref = id_categoriaref;
	}
	public Integer getId_sub_categoriaref() {
		return id_sub_categoriaref;
	}
	public void setId_sub_categoriaref(Integer id_sub_categoriaref) {
		this.id_sub_categoriaref = id_sub_categoriaref;
	}
	public Integer getId_unidaderef() {
		return id_unidaderef;
	}
	public void setId_unidaderef(Integer id_unidaderef) {
		this.id_unidaderef = id_unidaderef;
	}
	public Integer getId_marcaref() {
		return id_marcaref;
	}
	public void setId_marcaref(Integer id_marcaref) {
		this.id_marcaref = id_marcaref;
	}
	public Integer getId_ncm() {
		return id_ncm;
	}
	public void setId_ncm(Integer id_ncm) {
		this.id_ncm = id_ncm;
	}
	@Override
	public String toString() {
		return "Produtoref [codigo_de_barra=" + codigo_de_barra + ", id=" + id + ", descricao=" + descricao
				+ ", frequencia_pedido=" + frequencia_pedido + ", preco_por_tabela=" + preco_por_tabela + ", cst=" + cst
				+ ", icms=" + icms + ", nome=" + nome + ", preco_ultima_compra=" + preco_ultima_compra
				+ ", quantidade_estoque=" + quantidade_estoque + ", quantidade_minima=" + quantidade_minima
				+ ", id_fornecedor=" + id_fornecedor + ", id_categoriaref=" + id_categoriaref + ", id_sub_categoriaref="
				+ id_sub_categoriaref + ", id_unidaderef=" + id_unidaderef + ", id_marcaref=" + id_marcaref
				+ ", id_ncm=" + id_ncm + "]";
	}
	
	
	
	
}
