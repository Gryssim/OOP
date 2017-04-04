using System;

namespace Decorator
{
	public abstract class ShapeDecorator : IShape
	{
		protected IShape decoratedShape;

		public ShapeDecorator (IShape decoratedShape)
		{
			this.decoratedShape = decoratedShape;
		}

		public virtual void draw(){
			this.decoratedShape.draw();
		}
	}
}

