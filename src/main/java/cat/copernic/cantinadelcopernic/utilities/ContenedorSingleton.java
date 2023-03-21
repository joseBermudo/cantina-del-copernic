/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.utilities;

import cat.copernic.cantinadelcopernic.modelo.Contenedor;

/**
 *
 * @author marku
 */

    public class ContenedorSingleton {

        private static Contenedor instance;

        private ContenedorSingleton() {

        }

        public static Contenedor getInstance() {
            if (instance == null) {
                instance = new Contenedor();
            }

            return instance;
        }

        public static void setInformacion(String idcontenedor) {
            getInstance().setIdcontenedor(idcontenedor);
        }

        public static String getInformacion() {
            return getInstance().getIdcontenedor();
        }

    }


