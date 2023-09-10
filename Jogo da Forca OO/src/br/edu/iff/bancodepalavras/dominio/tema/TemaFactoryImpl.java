package br.edu.iff.bancodepalavras.dominio.tema;

import br.edu.iff.factory.EntityFactory;

public class TemaFactoryImpl extends EntityFactory implements TemaFactory {

	private static TemaFactoryImpl soleInstance;
	
	public static void createSoleInstance(TemaRepository repository) {
		if(soleInstance==null) {
			soleInstance = new TemaFactoryImpl(repository);
		}
	}
	
	public static TemaFactoryImpl getSoleInstance() {
		return soleInstance;
	}
	
	private TemaFactoryImpl(TemaRepository repository) {
		super(repository);
	}

	private TemaRepository getTemaRepository() {
        return (TemaRepository) this.getRepository();
    }
	
	@Override
	public Tema getTema(String nome) {
		return Tema.criar(this.getTemaRepository().getProximoId(), nome);
	}
	
}
