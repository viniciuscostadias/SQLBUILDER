
package br.com.DAO;

import br.com.DTO.UsuarioDTO;
import br.com.VIEWS.TelaLogin;
import br.com.VIEWS.TelaUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class PecasDAO {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void limpar() {
        TelaUsuarios.txtNomeUsu.setText(null);
        TelaUsuarios.txtEmail.setText(null);
        TelaUsuarios.txtUsuario.setText(null);
        TelaUsuarios.txtSenha.setText(null);
    }

    public int criarELogar(UsuarioDTO dto) {
        String sql = "insert into tb_usuarios (nome, email, nome_usuario, senha)value(?,?,?,?) ";
        conexao = ConexaoDAO.connector();

        try {

            pst = conexao.prepareStatement(sql);

            pst.setString(1, dto.getNomeUsuario());
            pst.setString(2, dto.getEmailUsuario());
            pst.setInt(3, dto.getIdUsuario());
            pst.setString(4, dto.getSenhaUsuario());
            pst.setString(5, dto.getNomeUsuUsuario());
            int go = pst.executeUpdate();

            if (go > 0) {

                JOptionPane.showMessageDialog(null, "adicionado com sucesso, seja bem vindo! ");

                TelaLogin log = new TelaLogin();
                log.setVisible(true);
                return 1;

            } else {
                return 0;
            }

        } catch (Exception e) {

            if (e.getMessage().contains("tb_usuarios.nome_usuario_UNIQUE")) {

                JOptionPane.showMessageDialog(null, "nome de usuario ja em uso");
                return 0;

            } else if (e.getMessage().contains("tb_usuarios.email")) {

                JOptionPane.showMessageDialog(null, "email ja em uso");
                return 0;

            } else {

                JOptionPane.showMessageDialog(null, e.getMessage());
                return 0;
            }

        }
    }

    public int logar(UsuarioDTO dto) {
        String sql = "select * from tb_usuarios where nome_usuario = ? and senha = ?";

        conexao = ConexaoDAO.connector();

        try {

            pst = conexao.prepareStatement(sql);

            pst.setString(1, dto.getNomeUsuario());
            pst.setString(4, dto.getSenhaUsuario());

            rs = pst.executeQuery();

            if (rs.next()) {
                TelaLogin log = new TelaLogin();
                log.setVisible(true);
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "nome de usuario e/ ou senha invalidas");
                return 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public void criar(UsuarioDTO dto) {
        String sql = "insert into tb_usuarios (id, nome, email, nome_usuario, senha) value(?, ?, ?, ?, ?) ";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, dto.getNomeUsuario());
            pst.setString(2, dto.getEmailUsuario());
            pst.setInt(3, dto.getIdUsuario());
            pst.setString(4, dto.getSenhaUsuario());
            pst.setString(5, dto.getNomeUsuUsuario());

            int go = pst.executeUpdate();

            if (go > 0) {
                limpar();
                TelaUsuarios.txtId.setText(null);
                JOptionPane.showMessageDialog(null, "adicionado com sucesso");
            }
        } catch (Exception e) {

            if (e.getMessage().contains("tb_usuarios.nome_usuario_UNIQUE")) {

                JOptionPane.showMessageDialog(null, "nome de usuario ja em uso");

            } else if (e.getMessage().contains("tb_usuarios.email")) {

                JOptionPane.showMessageDialog(null, "email ja em uso");

            } else if (e.getMessage().contains("tb_usuarios.PRIMARY")) {
                JOptionPane.showMessageDialog(null, "id ja em uso");
            } else {

                JOptionPane.showMessageDialog(null, e.getMessage());

            }
        }
    }

    public void search(UsuarioDTO dto) {
        String sql = "select * from tb_usuarios where id = ?";

        conexao = ConexaoDAO.connector();

        try {

            pst = conexao.prepareStatement(sql);

            pst.setInt(1, dto.getIdUsuario());
            rs = pst.executeQuery();

            if (rs.next()) {

                TelaUsuarios.txtNomeUsu.setText(rs.getString(2));
                TelaUsuarios.txtEmail.setText(rs.getString(3));
                TelaUsuarios.txtUsuario.setText(rs.getString(4));
                TelaUsuarios.txtSenha.setText(rs.getString(5));
            } else {

                limpar();
                JOptionPane.showMessageDialog(null, "Usuario não cadastrado");
            }
        } catch (Exception e) {
            limpar();
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    public void update(UsuarioDTO dto) {

        int res = JOptionPane.showConfirmDialog(null, "tem certeza que quer atualizar o usuario?",
                null, JOptionPane.YES_NO_OPTION);

        if (res == JOptionPane.YES_OPTION) {

            String sql = "update tb_usuarios set nome = ?, email = ?, nome_usuario = ?, senha = ? where id = ?";
            conexao = ConexaoDAO.connector();

            try {
                pst = conexao.prepareStatement(sql);

                pst.setString(1, dto.getNomeUsuario());
                pst.setString(2, dto.getEmailUsuario());
                pst.setString(3, dto.getNomeUsuUsuario());
                pst.setString(4, dto.getSenhaUsuario());
                pst.setInt(5, dto.getIdUsuario());

                int go = pst.executeUpdate();

                if (go > 0) {
                    limpar();
                    TelaUsuarios.txtId.setText(null);
                    JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar");

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public void deletar(UsuarioDTO dto) {

        int res = JOptionPane.showConfirmDialog(null, "tem certeza que quer deletar o usuario?",
                null, JOptionPane.YES_NO_OPTION);

        if (res == JOptionPane.YES_OPTION) {
            String sql = "delete from tb_usuarios where id = ?";

            conexao = ConexaoDAO.connector();

            try {
                pst = conexao.prepareStatement(sql);

                pst.setInt(1, dto.getIdUsuario());

                int go = pst.executeUpdate();

                if (go > 0) {
                    limpar();
                    TelaUsuarios.txtId.setText(null);
                    JOptionPane.showMessageDialog(null, "deletado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "erro ao deletar");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

    }
}
