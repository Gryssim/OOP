using System;

namespace Decorator
{
	public class Rectangle : IShape
	{
		public string shapeName;

		public Rectangle (string shapeName)
		{
			this.shapeName = shapeName;
		}

		public void draw(){
			Console.Write (this.shapeName + " Shape : Rectangle. ");
		}
	}
}

