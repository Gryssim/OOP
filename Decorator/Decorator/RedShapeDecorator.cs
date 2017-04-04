using System;

namespace Decorator
{
	public class RedShapeDecorator : ShapeDecorator
	{
		public RedShapeDecorator (IShape decoratedShape) : base(decoratedShape)
		{
		}

		public override void draw(){
			decoratedShape.draw();
			setRedBorder(decoratedShape);
		}

		public void setRedBorder(IShape _decoratedShape){
			Console.WriteLine("Border Color : Red");
		}
	}
}

