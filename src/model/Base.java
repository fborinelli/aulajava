package model;

import java.util.Date;

public abstract class Base {
	private int codigo;
	private Date dataHoraInclusao;
	private Date dataHoraEdicao;

	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Base [codigo=" + codigo + ", dataHoraInclusao=" + dataHoraInclusao + ", dataHoraEdicao="
				+ dataHoraEdicao + ", getCodigo()=" + getCodigo() + ", hashCode()=" + hashCode()
				+ ", getDataHoraInclusao()=" + getDataHoraInclusao() + ", getDataHoraEdicao()=" + getDataHoraEdicao()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((dataHoraEdicao == null) ? 0 : dataHoraEdicao.hashCode());
		result = prime * result + ((dataHoraInclusao == null) ? 0 : dataHoraInclusao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Base other = (Base) obj;
		if (codigo != other.codigo)
			return false;
		if (dataHoraEdicao == null) {
			if (other.dataHoraEdicao != null)
				return false;
		} else if (!dataHoraEdicao.equals(other.dataHoraEdicao))
			return false;
		if (dataHoraInclusao == null) {
			if (other.dataHoraInclusao != null)
				return false;
		} else if (!dataHoraInclusao.equals(other.dataHoraInclusao))
			return false;
		return true;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDataHoraInclusao() {
		return dataHoraInclusao;
	}

	public void setDataHoraInclusao(Date dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}

	public Date getDataHoraEdicao() {
		return dataHoraEdicao;
	}

	public void setDataHoraEdicao(Date dataHoraEdicao) {
		this.dataHoraEdicao = dataHoraEdicao;
	}

}
