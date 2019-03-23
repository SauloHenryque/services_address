	package br.com.saulo.address.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "ADDRESS")
@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@ToString(of = { "id" })
public class AddressEntidade implements Serializable {
	
	
    private static final long serialVersionUID = -5633260910164953251L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "RUA")
    private String rua;

    @Column(name = "NUMERO")
    private String numero;
    
    @Column(name = "CEP")
    private String cep;
    
    @Column(name = "CIDADE")
    private String cidade;
    
    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "PAIS")
    private String pais;
    
    @Column(name = "ID_STORE")
    private String id_store;
    
    @Column(name = "ID_ORDER")
    private String id_order;
    

}
