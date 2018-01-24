package negocio.entities;
import dados.MeuId;
public class Produtoref {
	@MeuId
	private String codigo_de_barra;
	private String id;
	private String descricao;
	private double frequencia_pedido;
	private double preco_por_tabela;
	private int  cst;
	private String icms;
	private String nome;
	private double preco_ultima_compra;
	private int quantidade_estoque;
	private int quantidade_minima;
	private String marca;
	private String unidade_de_medida;
	private String ncm;
	private int id_fornecedor;
	private int id_categoriaref;
	private int id_sub_categoriaref;
	private int id_unidaderef;
	private int id_marcaref;
	private int id_ncm;
	
	public Produtoref(String codigo_de_barra, String id, String descricao, double frequencia_pedido,
			double preco_por_tabela, int cst, String icms, String nome, double preco_ultima_compra,
			int quantidade_estoque, int quantidade_minima, String marca, String unidade_de_medida, String ncm,
			int id_fornecedor, int id_categoriaref, int id_sub_categoriaref, int id_unidaderef, int id_marcaref,
			int id_ncm) {
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
		this.marca = marca;
		this.unidade_de_medida = unidade_de_medida;
		this.ncm = ncm;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getFrequencia_pedido() {
		return frequencia_pedido;
	}

	public void setFrequencia_pedido(double frequencia_pedido) {
		this.frequencia_pedido = frequencia_pedido;
	}

	public double getPreco_por_tabela() {
		return preco_por_tabela;
	}

	public void setPreco_por_tabela(double preco_por_tabela) {
		this.preco_por_tabela = preco_por_tabela;
	}

	public int getCst() {
		return cst;
	}

	public void setCst(int cst) {
		this.cst = cst;
	}

	public String getIcms() {
		return icms;
	}

	public void setIcms(String icms) {
		this.icms = icms;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco_ultima_compra() {
		return preco_ultima_compra;
	}

	public void setPreco_ultima_compra(double preco_ultima_compra) {
		this.preco_ultima_compra = preco_ultima_compra;
	}

	public int getQuantidade_estoque() {
		return quantidade_estoque;
	}

	public void setQuantidade_estoque(int quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}

	public int getQuantidade_minima() {
		return quantidade_minima;
	}

	public void setQuantidade_minima(int quantidade_minima) {
		this.quantidade_minima = quantidade_minima;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getUnidade_de_medida() {
		return unidade_de_medida;
	}

	public void setUnidade_de_medida(String unidade_de_medida) {
		this.unidade_de_medida = unidade_de_medida;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public int getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(int id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	public int getId_categoriaref() {
		return id_categoriaref;
	}

	public void setId_categoriaref(int id_categoriaref) {
		this.id_categoriaref = id_categoriaref;
	}

	public int getId_sub_categoriaref() {
		return id_sub_categoriaref;
	}

	public void setId_sub_categoriaref(int id_sub_categoriaref) {
		this.id_sub_categoriaref = id_sub_categoriaref;
	}

	public int getId_unidaderef() {
		return id_unidaderef;
	}

	public void setId_unidaderef(int id_unidaderef) {
		this.id_unidaderef = id_unidaderef;
	}

	public int getId_marcaref() {
		return id_marcaref;
	}

	public void setId_marcaref(int id_marcaref) {
		this.id_marcaref = id_marcaref;
	}

	public int getId_ncm() {
		return id_ncm;
	}

	public void setId_ncm(int id_ncm) {
		this.id_ncm = id_ncm;
	}

	@Override
	public String toString() {
		return "Produto [codigo_de_barra=" + codigo_de_barra + ", id=" + id + ", descricao=" + descricao
				+ ", frequencia_pedido=" + frequencia_pedido + ", preco_por_tabela=" + preco_por_tabela + ", cst=" + cst
				+ ", icms=" + icms + ", nome=" + nome + ", preco_ultima_compra=" + preco_ultima_compra
				+ ", quantidade_estoque=" + quantidade_estoque + ", quantidade_minima=" + quantidade_minima + ", marca="
				+ marca + ", unidade_de_medida=" + unidade_de_medida + ", ncm=" + ncm + ", id_fornecedor="
				+ id_fornecedor + ", id_categoriaref=" + id_categoriaref + ", id_sub_categoriaref="
				+ id_sub_categoriaref + ", id_unidaderef=" + id_unidaderef + ", id_marcaref=" + id_marcaref
				+ ", id_ncm=" + id_ncm + "]";
	}
	
	
	
}
