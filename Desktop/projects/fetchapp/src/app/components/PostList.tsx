import { Post } from "../page";
import PostItem from "./PostItem";
interface Props {
  posts: Post[];
  loading: boolean;
}
export default function PostList({ posts, loading }: Props) {
  if (loading) return <p>Loading ... </p>;
  if (posts.length === 0) return <p>No results found</p>;
  return (
    <ul>
      {posts.map((post) => (
        <PostItem key={post.id} post={post} />
      ))}
    </ul>
  );
}
