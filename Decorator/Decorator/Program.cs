using System;

namespace Decorator
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			Circle circle = new Circle ("Normal Circle");
			Rectangle rectangle = new Rectangle ("Normal Rectangle");

			circle.draw ();
			Console.WriteLine ();
			rectangle.draw ();
			Console.WriteLine ();

			RedShapeDecorator redCircle = new RedShapeDecorator (circle);

			redCircle.draw ();
		}
	}
}
