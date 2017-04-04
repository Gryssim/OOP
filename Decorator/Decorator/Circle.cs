using System;

namespace Decorator
{
	public class Circle : IShape
	{
		public string shapeName;

		public Circle (string shapeName)
		{
			this.shapeName = shapeName;
		}

		public void draw(){
			Console.Write (this.shapeName  + " Shape : Circle. ");
		}
	}
}

