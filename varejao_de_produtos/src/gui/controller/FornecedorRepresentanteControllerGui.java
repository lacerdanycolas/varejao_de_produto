package gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import dados.Fornecedor_representanteRepository;
import dados.FornecedorrefRepository;
import dados.RepresentanteRepository;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.entities.Fornecedor_representante;
import negocio.entities.Fornecedorref;
import negocio.entities.Representante;

public class FornecedorRepresentanteControllerGui implements Initializable {

	@FXML
	private  TableView<Fornecedorref> tbViewFornecedores;

	@FXML
	private TableColumn<Fornecedorref, String> tbCollumIdForn;
	@FXML
	private TableColumn<Fornecedorref, String> tbCollumNomeForn;
	@FXML
	private TableColumn<Fornecedorref, String> tbCollumCnpjForn;
	@FXML
	private TableColumn<Fornecedorref, String> tbCollumSituacaoForn;


	@FXML
	private  TableView<Representante> tbViewRepresentante;

	@FXML
	private TableColumn<Representante, String> tbCollumIdRep;
	@FXML
	private TableColumn<Representante, String> tbCollumNomeRep;


	@FXML
	private Button buttonVoltarTela;


	private Collection<Fornecedorref> listafornecedor = new ArrayList<Fornecedorref>();
	private ObservableList<Fornecedorref> obslistafornecedor;
	private Collection<Representante> listrep;
	private Collection<Fornecedor_representante> listforrep;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		carregarTbFornecedor();

	}

	private void carregarTbFornecedor(){

		tbCollumIdForn.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tbCollumNomeForn.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tbCollumCnpjForn.setCellValueFactory(new PropertyValueFactory<>("Cnpj"));
		tbCollumSituacaoForn.setCellValueFactory(new PropertyValueFactory<>("Situacao"));

		try {
			listafornecedor = FornecedorrefRepository.getInstance().getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obslistafornecedor = FXCollections.observableArrayList(listafornecedor);
		tbViewFornecedores.setItems(obslistafornecedor);

	}

	/*private void carregarTbRepresentantes(Fornecedorref fornecedorclick){
	  try {

		  Collection<Representante> listrep = RepresentanteRepository.getInstance().getAll();

	for (Fornecedor_representante fornecedor_representante : listforrep) {
		if(fornecedor_representante.getId_fornecedor().equals(fornecedorclick.getId())){
			tbCollumIdFornecedorRep.setCellValueFactory(cellData -> new SimpleStringProperty(fornecedor_representante.getId_fornecedor().toString()));
			tbCollumDataInicioRep.setCellValueFactory(cellData -> new SimpleStringProperty(fornecedor_representante.getData_Inicio().toString()));
			tbCollumDataFimRep.setCellValueFactory(cellData -> new SimpleStringProperty(fornecedor_representante.getData_fim().toString()));
			for(Representante representante: listrep){
				if(representante.getId().equals(fornecedor_representante.getId_representante())){
					tbCollumIdRep.setCellValueFactory(cellData -> new SimpleStringProperty(fornecedor_representante.getId().toString()));
				}
			}
		}
	}


	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}*/

	@FXML
	private void carregarRepresentantes(){

		try {
			//listforrep = Fornecedor_representanteRepository.getInstance().getAll();
			listrep = RepresentanteRepository.getInstance().getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Fornecedorref fornecedor = tbViewFornecedores.getSelectionModel().getSelectedItem();
		Fornecedor_representante forrep = null;
		try {
			forrep = Fornecedor_representanteRepository.getInstance().getOne(fornecedor.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Representante representante : listrep) {
			if(representante.getId().equals(forrep.getId_representante())){
				tbCollumIdRep.setCellValueFactory(cellData -> new SimpleStringProperty(representante.getId().toString()));
				tbCollumNomeRep.setCellValueFactory(cellData -> new SimpleStringProperty(representante.getNome()));
			}
		}
	}



}
