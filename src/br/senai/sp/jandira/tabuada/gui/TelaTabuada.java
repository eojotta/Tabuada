package br.senai.sp.jandira.tabuada.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class TelaTabuada extends Application {


    @Override
    public void start(Stage stage) throws Exception {
            // definir o tamanho da tela //
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setTitle("Tabuada");


        // Criar o root - componente de leiaute principal //
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #ffffff;");


       // Criamos a cena e colocamos o root nela
        Scene scene = new Scene(root);



        //Criar o header da tela
        VBox header = new VBox();
        header.setPrefHeight(100);
        header.setStyle("-fx-background-color: #ff58de;");

        //Colocar o conteudo do header//
        Label labeltitulo = new Label("Tabuada");
        labeltitulo.setStyle("-fx-text-fill: white;-fx-font-size: 20px;-fx-font-weight: bold;");
        Label labelsubtitulo = new Label("Crie a tabuada que a sua imaginação mandar");

        // Colocar os Labels dentro do header
            header.getChildren().addAll(labelsubtitulo, labeltitulo);


        //Criar o grid do formulário//
        GridPane gridFormulario = new GridPane();
        gridFormulario.setPrefHeight(100);
        gridFormulario.setStyle("-fx-background-color: #ffffff;");

        //Conteudo do grid do formulário
        Label labelmultiplicando = new Label("multiplicando");
        TextField textFieldmultiplicando = new TextField();

        Label labelMenormultiplicador = new Label("Menor Multiplicador");
        TextField textFieldMenormultiplicador = new TextField();

        Label labelMaiormultiplicador = new Label("Maior Multiplicador");
        TextField textFieldMaiormultiplicador = new TextField();




        //Colocar os componentes no grid
        gridFormulario.add(labelmultiplicando, 0, 0);
        gridFormulario.add(textFieldmultiplicando, 1, 0);

        gridFormulario.add(labelMenormultiplicador, 0, 1);
        gridFormulario.add(textFieldMenormultiplicador, 1, 1);

        gridFormulario.add(labelMaiormultiplicador, 0, 2);
        gridFormulario.add(textFieldMaiormultiplicador, 1, 2);



        //Criar a caixa dos botões
        HBox boxBotoes = new HBox();
        boxBotoes.setPrefHeight(100);
        boxBotoes.setStyle("-fx-background-color: #602626;");



        //Fazer os Botoes
        Button botaoCalcular = new Button("Calcular");
        Button botaoLimpar = new Button("Limpar");
        Button botaoSair = new Button("Sair");



        //Adicionar os botoes a sua caixa
        boxBotoes.getChildren().addAll(botaoCalcular, botaoLimpar, botaoSair);


        //Criar a caixa de resultado
        VBox boxResultado = new VBox();
        boxResultado.setPrefHeight(100);
        boxResultado.setStyle("-fx-background-color: #ff58de");


        //Criar os componentes do BOXrESULTADOS
        Label labelResultado = new Label("Resultado");
        ListView listaTabuada = new ListView();
        String[] cidades = new String[5];
        cidades[0] = "Itapevi";
        cidades[1] = "Jandira";
        cidades[2] = "Barueri";
        cidades[3] = "Carapicuíba";
        cidades[4] = "Osasco";
        listaTabuada.getItems().addAll(cidades);
        listaTabuada.getItems().add("Cotia");
        listaTabuada.getItems().addAll("Curitiba");
        listaTabuada.getItems().addAll("Fortaleza");

        //Adicionando
        boxResultado.getChildren().addAll(labelResultado, listaTabuada);

        //Adicionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(boxBotoes);
        root.getChildren().add(boxResultado);




// Colocamos a cena no palco
        stage.setScene(scene);






        stage.show();

    }



}
