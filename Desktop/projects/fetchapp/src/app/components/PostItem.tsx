import { Post } from "../page";

interface Props {
  post: Post;
}
export default function PostItem({ post }: Props) {
  return (
    <li>
      <h3>{post.title}</h3>
      <p>{post.body}</p>
    </li>
  );
}
