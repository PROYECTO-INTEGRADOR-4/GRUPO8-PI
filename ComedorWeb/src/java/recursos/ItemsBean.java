/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import ec.edu.espoch.comedor.entidad.CServicio;
import ec.edu.espoch.comedor.entidad.CTipo;
import ec.edu.espoch.comedor.modelo.MServicio;
import ec.edu.espoch.comedor.modelo.MTipo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author ©foqc
 */
@ManagedBean
@RequestScoped
public class ItemsBean {

    private List<SelectItem> selectOneItems;

    /**
     * creates a new instance of tipoDocumentoItemsBean
     */
    public ItemsBean() {
    }

    //<editor-fold defaultstate="collapsed" desc="Cargar servicios">
    public List<SelectItem> getSelectOneItemsServicio() {
        try {
            this.selectOneItems = new ArrayList<>();
            List<CServicio> objS = MServicio.cargar();
            for (CServicio objServicio : objS) {
                SelectItem selectItem = new SelectItem(
                        objServicio.getCodigoservicio(),
                        objServicio.getDescripcionservicio()
                );
                this.selectOneItems.add(selectItem);
            }
        } catch (Exception e) {
            System.err.println("%%%%%%%%%%%%%%%%%%%% " + e.getMessage() + "%%%%%%%%%%%%%%%%%%%%");
        }
        return this.selectOneItems;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Cargar lista Usuarios">
    public List<SelectItem> getSelectOneItemsTipo() {
        try {
            this.selectOneItems = new ArrayList<>();
            List<CTipo> objTipo = MTipo.cargar();
            for (CTipo objT : objTipo) {
                SelectItem selectItem = new SelectItem(
                        objT.getIntTipoId(),
                        objT.getStrTipoDescripcion()
                );

                this.selectOneItems.add(selectItem);
            }
        } catch (Exception e) {
            System.err.println("%%%%%%%%%%%%%%%%%%%% " + e.getMessage() + "%%%%%%%%%%%%%%%%%%%%");
        }
        return this.selectOneItems;
    }
    //</editor-fold>
/*
     //<editor-fold defaultstate="collapsed" desc="Cargar lista Rol">
     public List<SelectItem> getSelectOneItemsRol() {
     try {
     this.selectOneItems = new ArrayList<>();
     List<cRol> objRoles = mRol.cargarRols();
     for (cRol objRol : objRoles) {
     SelectItem selectItem = new SelectItem(objRol.getIntIdRol(), objRol.getStrDescripcionRol());
     this.selectOneItems.add(selectItem);
     }
     } catch (Exception e) {
     System.err.println("%%%%%%%%%%%%%%%%%%%% " + e.getMessage() + "%%%%%%%%%%%%%%%%%%%%");
     }
     return this.selectOneItems;
     }
     //</editor-fold>

     public List<SelectItem> getSelectOneItemsTipoDocumento() {
     try {
     this.selectOneItems = new ArrayList<>();
     List<cTipoDocumento> tipoDocumentos = mTipoDocumento.cargarTipoDocumentos();
     for (cTipoDocumento tipoDocumento : tipoDocumentos) {
     SelectItem selectItem = new SelectItem(tipoDocumento.getIntIdTipoDocumento(), tipoDocumento.getStrDescripcionTipoDocumento());
     this.selectOneItems.add(selectItem);
     }
     } catch (Exception e) {
     System.err.println("%%%%%%%%%%%%%%%%%%%% " + e.getMessage() + "%%%%%%%%%%%%%%%%%%%%");
     }
     return this.selectOneItems;
     }

     public List<SelectItem> getSelectOneItemsClaseDocumento() {
     try {
     this.selectOneItems = new ArrayList<>();
     List<cClase> lstClases = mClase.cargarClases();
     lstClases.stream().map((objClase) -> new SelectItem(objClase.getIntIdClase(), objClase.getStrDescripcionClase())).forEach((selectItem) -> {
     this.selectOneItems.add(selectItem);
     });
     } catch (Exception e) {
     System.err.println("%%%%%%%%%%%%%%%%%%%% " + e.getMessage() + "%%%%%%%%%%%%%%%%%%%%");
     }
     return this.selectOneItems;
     }
     */
}
