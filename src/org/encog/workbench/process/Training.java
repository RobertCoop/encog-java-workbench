package org.encog.workbench.process;

import org.encog.neural.data.NeuralDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.training.hopfield.TrainHopfield;
import org.encog.workbench.EncogWorkBench;
import org.encog.workbench.dialogs.training.anneal.InputAnneal;
import org.encog.workbench.dialogs.training.anneal.ProgressAnneal;
import org.encog.workbench.dialogs.training.backpropagation.InputBackpropagation;
import org.encog.workbench.dialogs.training.backpropagation.ProgressBackpropagation;
import org.encog.workbench.dialogs.training.genetic.InputGenetic;
import org.encog.workbench.dialogs.training.genetic.ProgressGenetic;
import org.encog.workbench.dialogs.training.hopfield.InputHopfield;
import org.encog.workbench.dialogs.training.som.InputSOM;
import org.encog.workbench.dialogs.training.som.ProgressSOM;

public class Training {
	public static void performBackpropagation() {
		InputBackpropagation dialog = new InputBackpropagation(EncogWorkBench
				.getInstance().getMainWindow());
		if (dialog.process()) {
			BasicNetwork network = dialog.getNetwork();
			NeuralDataSet training = dialog.getTrainingSet();

			ProgressBackpropagation train = new ProgressBackpropagation(
					EncogWorkBench.getInstance().getMainWindow(), network,
					training, dialog.getLearningRate(), 
					dialog.getMomentum(),
					dialog.getMaxError());

			train.setVisible(true);
		}
	}

	public static void performAnneal() {
		InputAnneal dialog = new InputAnneal(EncogWorkBench.getInstance()
				.getMainWindow());
		if (dialog.process()) {
			BasicNetwork network = dialog.getNetwork();
			NeuralDataSet training = dialog.getTrainingSet();

			ProgressAnneal train = new ProgressAnneal(
					EncogWorkBench.getInstance().getMainWindow(), 
					network, 
					training, 
					dialog.getMaxError(), 
					dialog.getStartTemp(), 
					dialog.getEndTemp(),
					dialog.getCycles());

			train.setVisible(true);
		}
	}
	
	public static void performGenetic() {
		InputGenetic dialog = new InputGenetic(EncogWorkBench.getInstance()
				.getMainWindow());
		if (dialog.process()) {
			BasicNetwork network = dialog.getNetwork();
			NeuralDataSet training = dialog.getTrainingSet();
			
			ProgressGenetic train = new ProgressGenetic(
					EncogWorkBench.getInstance().getMainWindow(), 
					network, 
					training, 
					dialog.getMaxError(), 
					dialog.getPopulationSize(), 
					dialog.getMutationPercent(),
					dialog.getPercentToMate());

			train.setVisible(true);
		}
	}

	public static void performHopfield() {
		InputHopfield dialog = new InputHopfield(EncogWorkBench.getInstance()
				.getMainWindow());
		
		if( dialog.process())
		{
			BasicNetwork network = dialog.getNetwork();
			NeuralDataSet training = dialog.getTrainingSet();
			
			TrainHopfield train = new TrainHopfield(training,network);
			train.iteration();
			EncogWorkBench.displayMessage("Train Hopfield","Training Complete");
		}
		
	}

	public static void performSOM() {
		InputSOM dialog = new InputSOM(EncogWorkBench.getInstance()
				.getMainWindow());
		
		if( dialog.process())
		{
			BasicNetwork network = dialog.getNetwork();
			NeuralDataSet training = dialog.getTrainingSet();

			ProgressSOM train = new ProgressSOM(
					EncogWorkBench.getInstance().getMainWindow(), 
					network, 
					training, 
					dialog.getMaxError(), 
					dialog.getMethod(),
					dialog.getLearningRate());

			train.setVisible(true);			
		}
		
	}
}