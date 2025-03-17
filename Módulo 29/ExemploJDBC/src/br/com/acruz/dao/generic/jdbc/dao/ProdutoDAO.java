package br.com.acruz.dao.generic.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acruz.dao.generic.jdbc.ConnectionFactory;
import br.com.acruz.domin.Produto;

public class ProdutoDAO implements IProdutoDAO {
	
	@Override
	public Integer cadastrar(Produto produto) throws Exception{
		
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = getSqlInsertProduct();
			stm = connection.prepareStatement(sql);
			adicionarParametrosInsertPd(stm, produto);
			return stm.executeUpdate();
		}
		catch (Exception e){
			throw e;
		}
		finally {
			closeConnection(connection, stm, null);
		}
		
	}
	
	@Override
	public Integer atualizar(Produto produto) throws Exception{
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = getSqlUpdateProduct();
			stm = connection.prepareStatement(sql);
			adicionarParametrosUpdatePd(stm, produto);
			return stm.executeUpdate();
		}
		catch (Exception e){
			throw e;
		}
		finally {
			closeConnection(connection, stm, null);
		}
	}
	
	@Override
	public Produto buscar(String codigo) throws Exception{
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Produto produto = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = getSqlBuscar();
			stm = connection.prepareStatement(sql);
			adicionarParametrosBuscarPd(stm, codigo);
			rs = stm.executeQuery();
			
			if (rs.next()) {
				produto = new Produto();
				Long id = rs.getLong("ID");
				String nome = rs.getString("NOME");
				String cd = rs.getString("CODIGO");
				produto.setId(id);
				produto.setNome(nome);
				produto.setCodigo(cd);
				
			}
		}
		catch (Exception e){
			throw e;
		}
		finally {
			closeConnection(connection, stm, null);
		}
		return produto;
	}
	
	@Override
	public List<Produto> buscarTodos() throws Exception{
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Produto> list = new ArrayList<>();
		Produto produto = null;
	
		try {
			connection = ConnectionFactory.getConnection();
			String sql = getSqlBuscarAll();
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while (rs.next()) {
				produto = new Produto();
				Long id = rs.getLong("ID");
				String nome = rs.getString("NOME");
				String cd = rs.getString("CODIGO");
				produto.setId(id);
				produto.setNome(nome);
				produto.setCodigo(cd);
				list.add(produto);
			}
			
		}
		catch (Exception e){
			throw e;
		}
		finally {
			closeConnection(connection, stm, null);
		}
		return list;
	}
	
	@Override
	public Integer excluir(Produto produto) throws Exception{
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = getSqlDelete();
			stm = connection.prepareStatement(sql);
			adicionarParametroDelete(stm, produto);
			return stm.executeUpdate();
		}
		catch (Exception e){
			throw e;
		}
		finally {
			closeConnection(connection, stm, null);
		}
	}
	

//	_______________________________________________________________________________________________________//
	//Cadastrar//
	private String getSqlInsertProduct() {
		StringBuilder sb =  new StringBuilder();
		sb.append("INSERT INTO TB_PRODUTO (ID, CODIGO, NOME) ");
		sb.append("VALUES (nextval('SQ_PRODUTO'),?,?) ");
		return sb.toString();
	}
	
	private void adicionarParametrosInsertPd(PreparedStatement stm, Produto produto) throws SQLException {
		stm.setString(1, produto.getCodigo());
		stm.setString(2, produto.getNome());
	}
	
	//Atualizar//
	private String getSqlUpdateProduct() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE TB_PRODUTO ");
		sb.append("SET NOME = ?, SET CODIGO =  ? ");
		sb.append("WHERE ID = ?");
		return sb.toString();
	}
	
	private void adicionarParametrosUpdatePd(PreparedStatement stm, Produto produto) throws SQLException{
		stm.setString(1, produto.getNome());
		stm.setString(2, produto.getCodigo());
		stm.setLong(3, produto.getId());
	}
	
	//Buscar//
	private String getSqlBuscar(){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM TB_PRODUTO ");
		sb.append("WHERE CODIGO = ?");
		return sb.toString();
	}
	
	private void adicionarParametrosBuscarPd(PreparedStatement stm, String codigo) throws SQLException{
		stm.setString(1, codigo);
	}
	
	//Buscar Todos//
	private String getSqlBuscarAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM TB_PRODUTO ");
		return sb.toString();
	}
	
	//Excluir//
	private String getSqlDelete() {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM TB_PRODUTO ");
		sb.append("WHERE CODIGO = ?");
		return sb.toString();
	}
	
	private void adicionarParametroDelete(PreparedStatement stm, Produto produto) throws SQLException{
		stm.setString(1, produto.getCodigo());
	}
	
	
	
	private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		catch (SQLException e1) {
			 e1.printStackTrace();
		}
	}
	
}