/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocialjsf.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tmgrm
 */
@Entity
@Table(name = "post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
    , @NamedQuery(name = "Post.findById", query = "SELECT p FROM Post p WHERE p.id = :id")
    , @NamedQuery(name = "Post.findByTitulo", query = "SELECT p FROM Post p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Post.findByTexto", query = "SELECT p FROM Post p WHERE p.texto = :texto")
    , @NamedQuery(name = "Post.findByImagen", query = "SELECT p FROM Post p WHERE p.imagen = :imagen")
    , @NamedQuery(name = "Post.findByVideo", query = "SELECT p FROM Post p WHERE p.video = :video")
    , @NamedQuery(name = "Post.findByDestinatario", query = "SELECT p FROM Post p WHERE p.destinatario = :destinatario")
    , @NamedQuery(name = "Post.findByFecha", query = "SELECT p FROM Post p WHERE p.fecha = :fecha")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "texto")
    private String texto;
    @Size(max = 1000)
    @Column(name = "imagen")
    private String imagen;
    @Size(max = 1000)
    @Column(name = "video")
    private String video;
    @Basic(optional = false)
    @NotNull
    @Column(name = "destinatario")
    private int destinatario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "post")
    private Publicaciones publicaciones;
    @JoinColumns({
        @JoinColumn(name = "usuario_id", referencedColumnName = "id")
        , @JoinColumn(name = "usuario_id", referencedColumnName = "id")})
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumns({
        @JoinColumn(name = "usuario_id1", referencedColumnName = "id")
        , @JoinColumn(name = "usuario_id1", referencedColumnName = "id")})
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, String titulo, String texto, int destinatario, Date fecha) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.destinatario = destinatario;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(int destinatario) {
        this.destinatario = destinatario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Publicaciones getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(Publicaciones publicaciones) {
        this.publicaciones = publicaciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "redsocialjsf.entity.Post[ id=" + id + " ]";
    }
    
}
