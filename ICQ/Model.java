class Model{
	private Viewer viewer;
	public Model(Viewer viewer){
		this.viewer = viewer;
	}

	public void doAction(String value) {
		if(value.equals("Send message")){
			String ipAddress = viewer.getIpAddress();
			String messageText = viewer.getMessageText();
			System.out.println("IP: " + ipAddress);
			System.out.println("Message: " + messageText);
		} else if(value.equals("Clear TextAread")){

		}
	}
}