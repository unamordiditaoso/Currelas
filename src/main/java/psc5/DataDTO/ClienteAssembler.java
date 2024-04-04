package psc5.DataDTO;
import java.util.ArrayList;
import java.util.List;

import psc5.deustoimperiomoda.DataDomain.Cliente;
import psc5.deustoimperiomoda.DataDomain.TipoUsuario;


public class ClienteAssembler {
    private static ClienteAssembler instance;

    private ClienteAssembler() { }

    public static ClienteAssembler getInstance() {
        if(instance == null) {
            instance = new ClienteAssembler();
        }
        return instance;
    }

    public ClienteDTO clienteToDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setContrasena(cliente.getContrasena());
        dto.setDni(cliente.getDni());
        dto.setNombre(cliente.getNombre());
        dto.setContrasena(cliente.getCorreo());
        if(cliente.getTipoUsuario() == TipoUsuario.Cliente) {
            dto.setTipoUsuario("Cliente");
        }else if(cliente.getTipoUsuario() == TipoUsuario.Administrador) {
            dto.setTipoUsuario("Administrador");
        }

        return dto; 
    }

    public List<ClienteDTO> clienteToDTO(List<Cliente> clientes) {
        List<ClienteDTO> clienteDTOs = new ArrayList<>();

        for (Cliente cliente : clientes) {
            clienteDTOs.add(this.clienteToDTO(cliente));
        }

        return clienteDTOs;

    }

}
