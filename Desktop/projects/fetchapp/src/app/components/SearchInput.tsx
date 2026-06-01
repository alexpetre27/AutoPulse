interface Props {
  query: string;
  onChange: (value: string) => void;
}
export default function SearchInput({ query, onChange }: Props) {
  return (
    <div className="search-wrap">
      <input
        value={query}
        onChange={(e) => onChange(e.target.value)}
        placeholder="Search posts"
      />
    </div>
  );
}
