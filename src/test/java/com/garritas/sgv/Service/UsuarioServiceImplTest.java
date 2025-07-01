package com.garritas.sgv.Service;

import com.garritas.sgv.model.Usuario;
import com.garritas.sgv.model.Cargo;
import com.garritas.sgv.repository.UsuarioRepository;
import com.garritas.sgv.service.UsuarioServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGuardarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setCodigo("admin123");
        usuario.setContrasena("segura");
        usuario.setCargo(new Cargo());

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario resultado = usuarioService.guardar(usuario);

        assertNotNull(resultado);
        assertEquals("admin123", resultado.getCodigo());
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void testBuscarPorCodigo() {
        Usuario usuario = new Usuario();
        usuario.setCodigo("admin123");

        when(usuarioRepository.findByCodigo("admin123")).thenReturn(Optional.of(usuario));

        Optional<Usuario> resultado = usuarioService.buscarPorCodigo("admin123");

        assertTrue(resultado.isPresent());
        assertEquals("admin123", resultado.get().getCodigo());
    }

    @Test
    void testListarUsuarios() {
        Usuario u1 = new Usuario();
        u1.setCodigo("user1");

        Usuario u2 = new Usuario();
        u2.setCodigo("user2");

        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(u1, u2));

        List<Usuario> lista = usuarioService.listar();

        assertEquals(2, lista.size());
    }
}
