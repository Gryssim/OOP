using System;
using System.IO;
using System.Collections.Generic;

namespace Mediator
{	

	public delegate void MessageReceivedEventHandler(Message message, Person from);

	public class Mediator{
		public event MessageReceivedEventHandler MessageReceived;

		public void Send(Message message, Person from){
			if (MessageReceived != null) {
				Console.WriteLine ("Sending '{0}' from {1} -- {2}:{3}", 
					message.message, 
					from.userName,
					message.timeSent.Hour % 12,
					message.timeSent.Minute);
				MessageReceived (message, from);
			}
		}
	}

	public class Person{

		Mediator mediator;
		public string userName;

		public Person(Mediator _mediator, string _userName){
			mediator = _mediator;
			userName = _userName;
			mediator.MessageReceived += new MessageReceivedEventHandler (Receive);
		}

		private void Receive(Message message, Person from){
			if (from.userName != userName) {
				string writable = string.Format ("{0} received '{1}' from {2} -- {3}:{4}", 
					                  userName, 
					                  message.message, 
					                  from.userName, 
					                  message.timeSent.Hour % 12, 
					                  message.timeSent.Minute);
				Console.CursorLeft = Console.BufferWidth - writable.Length;
				Console.WriteLine (writable);
			}
		}
		public void sendMessage(string _message){
			Message message = new Message(_message);
			mediator.Send (message, this);
		}

	}

	public class Message{
		public string message;
		public DateTime timeSent;

		public Message(string _message){
			message = _message;
			timeSent = DateTime.Now;
		}
	}

	

	public class Client
	{
		public static void Main (string[] args)
		{	
			Mediator mediator = new Mediator ();
			Person user = new Person (mediator, "Nyk");
			List<Person> people = new List<Person> () {
				new Person (mediator, "Doug"),
				new Person (mediator, "Jane"),
				new Person (mediator, "Joe")
			};
			Console.Write ("Message: ");
			String message = Console.ReadLine ();


			user.sendMessage (message);

		}
	}

}
