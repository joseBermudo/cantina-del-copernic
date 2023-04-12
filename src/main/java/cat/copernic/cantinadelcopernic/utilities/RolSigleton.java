/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.utilities;

import cat.copernic.cantinadelcopernic.modelo.Rol;



/**
 *
 * @author andre
 */
public class RolSigleton {
       private static Rol instance;

        private RolSigleton() {

        }

    /**
     *
     * @return
     */
    public static Rol getInstance() {
            if (instance == null) {
                instance = new Rol();
            }

            return instance;
        }

    /**
     *
     * @param idRol
     */
    public static void setInformacion(int idRol) {
            getInstance().setIdroles(idRol);
        }

    /**
     *
     * @return
     */
    public static int getInformacion() {
            return getInstance().getIdroles();
        }
}
