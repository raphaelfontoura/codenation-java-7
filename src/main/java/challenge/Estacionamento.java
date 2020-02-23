package challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Estacionamento {
	
	private int totalVagas = 10;
	
	List<Carro> carros = new ArrayList<>();
	

    public void estacionar(Carro carro) {
    	if (carro.getMotorista() == null) throw new EstacionamentoException("Não permitido carro autonomo.");
    	if (carro.getMotorista().getIdade() < 18) throw new EstacionamentoException("Motorista menor de idade.");
    	if (carro.getMotorista().getPontos() > 20) throw new EstacionamentoException("Habilitação suspensa.");
    	if (carros.size() < totalVagas) {
    		carros.add(carro);
    	} else if(tentaNovaVaga()) {
    		carros.add(carro);
    	}
    	
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
    	if (!carros.contains(carro)) {
    		return false;
    	}
        return true;
    }
    
    public boolean tentaNovaVaga() {
    	for (Carro carro : carros) {
			if(carro.getMotorista().getIdade() < 55) {
				carros.remove(carro);
				return true;
			}
		}
    	throw new EstacionamentoException("Todos as vagas estão ocupadas");
    }
    
}
