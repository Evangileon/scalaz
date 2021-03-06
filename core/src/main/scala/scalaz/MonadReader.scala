package scalaz

////
/**
 *
 */
////
trait MonadReader[F[_, _], S] extends Monad[F[S, ?]] { self =>
  ////

  def ask: F[S,S]
  def local[A](f: S => S)(fa: F[S,A]): F[S,A]
  def scope[A](k: S)(fa: F[S,A]): F[S,A] = local(_ => k)(fa)
  def asks[A](f: S => A): F[S,A] = map(ask)(f)

  ////
  
}

object MonadReader {
  @inline def apply[F[_, _], S](implicit F: MonadReader[F, S]): MonadReader[F, S] = F

  ////

  ////
}
