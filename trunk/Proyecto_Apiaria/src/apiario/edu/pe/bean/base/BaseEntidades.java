/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apiario.edu.pe.bean.base;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class BaseEntidades implements Serializable {
    private boolean sel;
    private boolean success;
    private List<Integer> listaEliminar;
    private String msgResult;
    
    public BaseEntidades() {
        super();
    }

	public boolean isSel() {
		return sel;
	}

	public void setSel(boolean sel) {
		this.sel = sel;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<Integer> getListaEliminar() {
		return listaEliminar;
	}

	public void setListaEliminar(List<Integer> listaEliminar) {
		this.listaEliminar = listaEliminar;
	}

	public String getMsgResult() {
		return msgResult;
	}

	public void setMsgResult(String msgResult) {
		this.msgResult = msgResult;
	}
    
}
