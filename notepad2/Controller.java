
	
	Viewer viewer;


   Controller(Viewer viewer)  {
  	this.viewer = viewer;
  }

  public void actionPerformed(ActionEvent event) {
  	String command = event.getActionCommand();

	model.doAction(command);
  }
}