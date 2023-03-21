import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in); // Variavel para entrada de dados
        float peso; //Variavel para receber o peso
        float altura; //Variavel para receber a altura
        float imc; // Variavel para receber o calculo

        System.out.println("Entre com o seu peso: ");
        peso = entrada.nextFloat();

        System.out.println("Entre com a sua altura: ");
        altura = entrada.nextFloat();

        imc = peso / (altura * altura);

        System.out.println("IMC: " + imc);

        if(imc<=18.5){
            System.out.println("Abaixo do peso!");
        }

        else if(imc<24.9){
            System.out.println("Peso normal!");
        }

        else if(imc<29.9){
            System.out.println("Sobrepeso!");
        }

        else if(imc<34.9){
            System.out.println("Obesidade grau 1!");
        }

        else if(imc<39.9){
            System.out.println("Obesidade grau 2!");
        }

        else{
            System.out.println("Obesidade grau 3!");
        }

        entrada.close();
}
}