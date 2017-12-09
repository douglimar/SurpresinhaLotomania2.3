package br.com.douglimar.surpresinha_lotomania;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Douglimar Moraes on 02/12/17.
 *
 *
 */

class Surpresinha {

    public String generateLotomaniaGame() {

        int numsLotomania[] = new int[50];

        int j = 0 ;
        int indice;
        StringBuilder Retorno = new StringBuilder();
        Random random = new Random();

        for (int i = 0 ; i < 50; i++) {
            indice = random.nextInt(101);

            // Consiste o nro. gerado, para garantir que ele é unico
            for (int k = 0; k <= 100; k++) {
                if (consisteJogo(numsLotomania, indice) || indice == 0 ) {
                    indice = random.nextInt(101);
                }
            }


            numsLotomania[i] = indice;
        }

        Arrays.sort(numsLotomania);

        for (int i = 0; i < 50; i++) {
            j++;

            if (numsLotomania[i]==100)
                Retorno.append(" 00");
            else
                if (numsLotomania[i] < 10)
                    Retorno.append(" 0").append(numsLotomania[i]);
                else
                    Retorno.append(" ").append(numsLotomania[i]);

            if (j == 8 )  {
                Retorno.append('\n');
                j = 0 ;
            }

        }

        return Retorno.toString();
    }

    private boolean consisteJogo(int pArray[], int PNumero) {

        boolean Retorno = false;

        for (int aPArray : pArray) {
            if (aPArray == PNumero) {
                Retorno = true;
                break;
            }
        }

        return Retorno;
    }

}
