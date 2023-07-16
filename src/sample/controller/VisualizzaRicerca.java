package sample.controller;

import sample.Main;
import sample.model.dao.LavoratoreDaoImpl;
import sample.model.dao.LavoroDaoImpl;
import sample.model.dao.RicercaDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Lavoratore;
import sample.model.Lavoro;
import sample.model.Ricerca;

import java.io.IOException;
import java.util.List;

public class VisualizzaRicerca {
    @FXML
    public TableView<Lavoratore> ProfiloLavoratore;
    @FXML
    public TableColumn<Lavoratore, String> IdLavoratore;
    @FXML
    public TableColumn<Lavoratore, String> Nome;
    @FXML
    public TableColumn<Lavoratore, String>  Cognome;
    @FXML
    public TableColumn<Lavoratore, String>  Mail;
    @FXML
    public TableColumn<Lavoratore, String>  Telefono;
    @FXML
    public TableColumn<Lavoratore, String>  DataNascita;
    @FXML
    public TableColumn<Lavoratore, String>  LuogoNascita;
    @FXML
    public TableColumn<Lavoratore, String>  Via;
    @FXML
    public TableColumn<Lavoratore, String>  NumeroCivico;
    @FXML
    public TableColumn<Lavoratore, String>  Paese;
    @FXML
    public TableColumn<Lavoratore, String>  Nazionalità;
    @FXML
    public TableColumn<Lavoratore, List>  Esperienze;
    @FXML
    public TableColumn<Lavoratore, List> Lingue;
    @FXML
    public TableColumn<Lavoratore, String>  Patente;
    @FXML
    public TableColumn<Lavoratore, String>  Automunito;
    @FXML
    public TableColumn<Lavoratore, String>  InizioDispComune1;
    @FXML
    public TableColumn<Lavoratore, String>  FineDispComune1;
    @FXML
    public TableColumn<Lavoratore, String>  InizioDispComune2;
    @FXML
    public TableColumn<Lavoratore, String>  FineDispComune2;
    @FXML
    public TableColumn<Lavoratore, String>  Comune1;
    @FXML
    public TableColumn<Lavoratore, String>  Comune2;
    @FXML
    public TableColumn<Lavoratore, String>  NomeEmergenza;
    @FXML
    public TableColumn<Lavoratore, String>  CognomeEmergenza;
    @FXML
    public TableColumn<Lavoratore, String>  MailEmergenza;
    @FXML
    public TableColumn<Lavoratore, String>  TelefonoEmergenza;

    ObservableList<Lavoratore> ElencoLavoratori = FXCollections.observableArrayList();
    ObservableList<Lavoro> ElencoLavori = FXCollections.observableArrayList();

    @FXML
    public TableView<Lavoro> ProfiloLavori;
    @FXML
    public TableColumn<Lavoro, String>  IdLavoratoreLavoro;
    @FXML
    public TableColumn<Lavoro, String>  NomeLavoro;
    @FXML
    public TableColumn<Lavoro, String>  NomeAzienda;
    @FXML
    public TableColumn<Lavoro, String>  LuogoLavoro;
    @FXML
    public TableColumn<Lavoro, String>  RetribuzioneGiornaliera;
    @FXML
    public TableColumn<Lavoro, String>  RetribuzioneLorda;
    @FXML
    public TableColumn<Lavoro, String>  Mansione1;
    @FXML
    public TableColumn<Lavoro, String>  Mansione2;
    @FXML
    public TableColumn<Lavoro, String>  DataInizio;
    @FXML
    public TableColumn<Lavoro, String>  DataFine;

    @FXML
    private Label avviso;
    @FXML
    private Button goBack;

    public void setRicerca(Ricerca search){
        RicercaDaoImpl ricercaDao = new RicercaDaoImpl();
        LavoratoreDaoImpl lavoratoreDao = new LavoratoreDaoImpl();
        LavoroDaoImpl lavoroDao = new LavoroDaoImpl();
        ElencoLavoratori.clear();
        String tipo1 = new String();
        String booleano = new String();
        String tipo2 = new String();
        int size = search.getTipoParametro().size();

        tipo1 = search.getTipoParametro().get(0);
        if (size > 1){
           booleano = search.getTipoParametro().get(1);
           tipo2 = search.getTipoParametro().get(2);
        }
        if ( size > 1 && booleano.equals("AND") && (( tipo1.equals("LuogoRes") && tipo2.equals("LuogoRes") ) ||
                    ( tipo1.equals("Automunito") && tipo2.equals("Automunito") ) ||
                    ( tipo1.equals("Patente") && tipo2.equals("Patente") ) )
        ){
            avviso.setText("La ricerca inserita (due luoghi di residenza, due patenti, due automuniti in AND) non ha senso.");

        }
        else if(search.getTipoParametro().size() == 1 && search.getTipoParametro().get(0) == "Lavoratore" ) {
            Lavoratore lavoratore = lavoratoreDao.getLavoratore(search.getRicercaLavoratori().get(0));
            ElencoLavoratori.add(lavoratore);
            
            List<Lavoro> lavori= lavoroDao.getLavori(search.getRicercaLavoratori().get(0));
            for(Lavoro lavoroPerId : lavori){
                ElencoLavori.add(lavoroPerId);
            }
        }
        else if( size > 1 &&  booleano.equals("AND") && (search.getTipoParametro().size() == 3 && search.getTipoParametro().get(0) == "Lavoratore" && search.getTipoParametro().get(2) == "Lavoratore" )) {
            Lavoratore lavoratore1 = lavoratoreDao.getLavoratore(search.getRicercaLavoratori().get(0));
            ElencoLavoratori.add(lavoratore1);
            List<Lavoro> lavori1= lavoroDao.getLavori(search.getRicercaLavoratori().get(0));
            for(Lavoro lavoroPerId : lavori1){
                ElencoLavori.add(lavoroPerId);
            }

            Lavoratore lavoratore2 = lavoratoreDao.getLavoratore(search.getRicercaLavoratori().get(1));
            ElencoLavoratori.add(lavoratore2);
            List<Lavoro> lavori2= lavoroDao.getLavori(search.getRicercaLavoratori().get(1));
            for(Lavoro lavoroPerId : lavori2){
                ElencoLavori.add(lavoroPerId);
            }
        }
        else if (search.getTipoParametro().size() == 1){
            List<String> elencoId = ricercaDao.ricercaSemplice(search);

            for (int i = 0; i < elencoId.size(); i++){
                Lavoratore lavoratore = lavoratoreDao.getLavoratore((elencoId.get(i)));
                ElencoLavoratori.add(lavoratore);

                List<Lavoro> lavori= lavoroDao.getLavori(elencoId.get(i));
                for(Lavoro lavoroPerId : lavori){
                    ElencoLavori.add(lavoroPerId);
                }
            }
        }
        else if (search.getTipoParametro().size() == 3){
            booleano = search.getTipoParametro().get(1);

            if (booleano.equals("AND")){
                List<String> elencoId = ricercaDao.ricercaComplessaAND(search);

                for (int i = 0; i < elencoId.size(); i++){
                    Lavoratore lavoratore = lavoratoreDao.getLavoratore((elencoId.get(i)));
                    ElencoLavoratori.add(lavoratore);

                    List<Lavoro> lavori= lavoroDao.getLavori(elencoId.get(i));
                    for(Lavoro lavoroPerId : lavori){
                        ElencoLavori.add(lavoroPerId);
                    }
                }
            }
            else{
                List<String> elencoId = ricercaDao.ricercaComplessaOR(search);

                for (int i = 0; i < elencoId.size(); i++){
                    Lavoratore lavoratore = lavoratoreDao.getLavoratore((elencoId.get(i)));
                    ElencoLavoratori.add(lavoratore);

                    List<Lavoro> lavori= lavoroDao.getLavori(elencoId.get(i));
                    for(Lavoro lavoroPerId : lavori){
                        ElencoLavori.add(lavoroPerId);
                    }
                }
            }
        }

        IdLavoratore.setCellValueFactory( new PropertyValueFactory<>("idLavoratore"));
        Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        Mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        Telefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        DataNascita.setCellValueFactory(new PropertyValueFactory<>("dataNascita"));
        LuogoNascita.setCellValueFactory(new PropertyValueFactory<>("luogoNascita"));
        Via.setCellValueFactory(new PropertyValueFactory<>("via"));
        NumeroCivico.setCellValueFactory(new PropertyValueFactory<>("numeroCivico"));
        Paese.setCellValueFactory(new PropertyValueFactory<>("paese"));
        Nazionalità.setCellValueFactory(new PropertyValueFactory<>("nazionalità"));
        Esperienze.setCellValueFactory(new PropertyValueFactory<>("esperienze"));
        Lingue.setCellValueFactory(new PropertyValueFactory<>("lingue"));
        Patente.setCellValueFactory(new PropertyValueFactory<>("patente"));
        Automunito.setCellValueFactory(new PropertyValueFactory<>("automunito"));
        Comune1.setCellValueFactory(new PropertyValueFactory<>("comune1"));
        Comune2.setCellValueFactory(new PropertyValueFactory<>("comune2"));
        InizioDispComune1.setCellValueFactory(new PropertyValueFactory<>("dataInizioDisponibilità_comune1"));
        FineDispComune1.setCellValueFactory(new PropertyValueFactory<>("dataFineDisponibilità_comune1"));
        InizioDispComune2.setCellValueFactory(new PropertyValueFactory<>("dataInizioDisponibilità_comune2"));
        FineDispComune2.setCellValueFactory(new PropertyValueFactory<>("dataFineDisponibilità_comune2"));
        NomeEmergenza.setCellValueFactory(new PropertyValueFactory<>("nomeEmergenza"));
        CognomeEmergenza.setCellValueFactory(new PropertyValueFactory<>("cognomeEmergenza"));
        MailEmergenza.setCellValueFactory(new PropertyValueFactory<>("mailEmergenza"));
        TelefonoEmergenza.setCellValueFactory(new PropertyValueFactory<>("telEmergenza"));
        ProfiloLavoratore.setItems(ElencoLavoratori);

        IdLavoratoreLavoro.setCellValueFactory(new PropertyValueFactory<>("idLavoratore"));
        NomeLavoro.setCellValueFactory(new PropertyValueFactory<>("nomeLavoro"));
        NomeAzienda.setCellValueFactory(new PropertyValueFactory<>("nomeAzienda"));
        LuogoLavoro.setCellValueFactory(new PropertyValueFactory<>("luogoLavoro"));
        RetribuzioneGiornaliera.setCellValueFactory(new PropertyValueFactory<>("retribuzioneGiornaliera"));
        RetribuzioneLorda.setCellValueFactory(new PropertyValueFactory<>("retribuzioneLorda"));
        Mansione1.setCellValueFactory(new PropertyValueFactory<>("mansione_1"));
        Mansione2.setCellValueFactory(new PropertyValueFactory<>("mansione_2"));
        DataInizio.setCellValueFactory(new PropertyValueFactory<>("dataInizio"));
        DataFine.setCellValueFactory(new PropertyValueFactory<>("dataFine"));
        ProfiloLavori.setItems(ElencoLavori);
    }

    public void tornaIndietro(ActionEvent actionEvent)throws IOException {
        Main nuovaScena = new Main();
        nuovaScena.changeScene("view/HomePage.fxml");
    }
}
