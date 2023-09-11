package com.example.pinpassionparty;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloController {
    public TextField nom;
    @FXML
    public TextField prenom;
    @FXML
    public TextField email;
    @FXML
    public TextField motDePasse;
    @FXML
    public TextField motDePasseConfirm;
    @FXML
    public Label emailInvalide;
    @FXML
    public Label MotDePasseInvalide;
    @FXML
    public Label confirmMotDePasseInvalide;
    @FXML
    public Button buttonCreerCompte;
    @FXML
    public Label validationCreationCompte;
    @FXML
    public Button SeConnecter;
    @FXML
    public Label emailInvalideConnexion;
    @FXML
    public Label MotDePasseInvalideConnexion;
    @FXML
    public TextField emailConnexion;
    @FXML
    public TextField mdpConnexion;
    @FXML
    public Label confirmationConnexion;

    @FXML
    List<Utilisateur> listeUtilisateurs=new ArrayList<>();
    public void ajouterUtilisateur(){
        Utilisateur utilisateur1= new Utilisateur("Segond","Guillaume","millecactus@gmail.com", "Guillaume12!");
        listeUtilisateurs.add(utilisateur1);

        Utilisateur utilisateur2= new Utilisateur("Geslot", "Cassandra", "cassandrageslot77@gmail.com", "14RuedesRosiers!");
        listeUtilisateurs.add(utilisateur2);
    }
    public void afficherUtilisateur(){
        for(Utilisateur users : listeUtilisateurs){
            System.out.print(" Nom : " + users.getNom()+
                    "\n Prenom :" + users.getPrenom()+
                    "\n Email :" + users.getEmail()+
                    "\n Mot de Passe :" + users.getMotDePasse()
            );
        }
    }

    @FXML
    private void ouvrirFenetre(String fxmlLoader) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource(fxmlLoader));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ouvrirFenetreP0() throws IOException {
        ouvrirFenetre("fenetreP0.fxml");
    }

    @FXML
    private void ouvrirFenetreP1() throws IOException {
        ouvrirFenetre("fenetreP1.fxml");
    }

    @FXML
    private void ouvrirFenetreP2() throws IOException {
            ouvrirFenetre("fenetreP2.fxml");
    }

    @FXML
    private void ouvrirFenetreP3() throws IOException {
            ouvrirFenetre("fenetreP3.fxml");
    }

    @FXML
    private void ouvrirFenetreP4() throws IOException {
            ouvrirFenetre("fenetreP4.fxml");
    }

    @FXML
    private void ouvrirFenetreP5() throws IOException {
            ouvrirFenetre("fenetreP5.fxml");
    }

    @FXML
    public void ouvrirFormulaireInscription(MouseEvent mouseEvent) throws IOException {
        ouvrirFenetre("formulaireInscription.fxml");
    }
    @FXML
    public void ouvrirPageConnexion(MouseEvent mouseEvent) throws IOException {
        ouvrirFenetre("connexionPage.fxml");
    }
    @FXML
    public void authentification(){
        ajouterUtilisateur();

        buttonCreerCompte.setOnMouseClicked(event-> {
            boolean authentificationMdp=false;
            boolean authentificationEmail=false;
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$");
            Matcher match = pattern.matcher(email.getText());

            //conformité des 2 mot de passe
                if ((motDePasse.getText()).equals(motDePasseConfirm.getText())) {
                    confirmMotDePasseInvalide.setText("");
                    authentificationMdp=true;
                } else {
                    confirmMotDePasseInvalide.setText(" Mot de passe non identiques");
                }

            //conformité de la valdiation de l'adresse mail (selon la regex)
                if(match.matches()) {
                    emailInvalide.setText("");
                    authentificationEmail=true;
                }else{
                    authentificationEmail=false;
                    emailInvalide.setText("Adresse mail invalide ");
            }

            if(nom.getText().isEmpty() || prenom.getText().isEmpty() ||motDePasse.getText().isEmpty() ||motDePasseConfirm.getText().isEmpty()){
                validationCreationCompte.setText(" ! Tout les champs sont requis !");
                authentificationMdp=false;
            }

            if(authentificationEmail && authentificationMdp){
                validationCreationCompte.setText("Félicitations, vous étes inscrit avec succès !");
            }

        });
    }

    @FXML
    public void authentificationConnexion(){
        ajouterUtilisateur();//simulation d'une base de données
        SeConnecter.setOnMouseClicked(event ->{
            boolean isAuthentificationOK=false;
            for(Utilisateur utilisateur :listeUtilisateurs) {
                if ((emailConnexion.getText()).equals(utilisateur.getEmail()) && mdpConnexion.getText().equals(utilisateur.getMotDePasse())) {
                    emailInvalideConnexion.setText("");
                    isAuthentificationOK = true;
                    break;//une fois que l'adresse a été trouvée, on sort de la boucle // lorsque la condition d'arret est remplie, on sort de la boucle
                }
            }

            //affichage du résultat
            if(isAuthentificationOK){
                confirmationConnexion.setText("Félicitations, vous étes inscrit avec succès !");
            }else{
                confirmationConnexion.setText("Adresse Email ou Mot de passe incorrect");
            }
        }
        );
    }
}