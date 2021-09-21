package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import model.Store;

public class Main {

	private BufferedReader br;
	private BufferedWriter bw;
	private Store store;

	public Main() {
		store= new Store();
		br= new BufferedReader(new InputStreamReader(System.in));
		bw= new BufferedWriter(new OutputStreamWriter(System.out));
	}

	public static void main(String[] args) {
		Main ui= new Main();
		
		try {
			ui.numOfCases();
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// El numero de casos que se entra por consola, determina cuantos casos van a entrar
	public void numOfCases() throws NumberFormatException, IOException {
		int cases= Integer.parseInt(br.readLine());
		while(cases!=0){
			int cashRegisters = Integer.parseInt(br.readLine());
			int stands = Integer.parseInt(br.readLine());
			store= new Store(cashRegisters, stands);
			while(stands!=0) {
				createNewStand();
				stands--;
			}
			int numOfClients= Integer.parseInt(br.readLine());
			store.setNumOfClients(numOfClients);
			store.createClientList();
			while(numOfClients!=0) {
				store.addClients(br.readLine());
				numOfClients--;
			}
			test();
			cases--;
		}
	}

	public void createNewStand() throws IOException {
		String nameAndLevels= br.readLine();
		String[] separateNameAndLevel=nameAndLevels.split(" ");
		String name= separateNameAndLevel[0];
		int levels= Integer.parseInt(separateNameAndLevel[1]);
		String[] values= new String[levels];
		for(int c=0; c< values.length;c++) {
			values[c]=br.readLine();
		}
		store.createStand(name, levels, values);
	}
	
	
	
	public void test() throws IOException {
		bw.write(store.printStands());
		bw.write(store.printClients());
		bw.flush();
	}

}


